package com.in28minutes.springboot.microservice.example.forex;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.in28minutes.springboot.microservice.example.forex.exceptions.FSDataNotFoundException;

@RestController
public class ForexController {

  private Logger logger = LoggerFactory.getLogger( this.getClass() );

  @Autowired
  private Environment environment;
  
  @Autowired
  private ExchangeValueRepository repository;
  
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue
    (@PathVariable String from, @PathVariable String to) throws FSDataNotFoundException
  {
    
    ExchangeValue exchangeValue = 
        repository.findByFromAndTo(from, to);

    if (exchangeValue == null){
        logger.error( "No exchange rate found for {} to {}",from,to );
        throw new FSDataNotFoundException( "No exchange rate found for "+from+" to "+to );
    }
    
    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));

    try
    {
      exchangeValue.setIp( InetAddress.getLocalHost().getHostAddress() );
    }
    catch ( UnknownHostException e )
    {
      exchangeValue.setIp( "Undetermined" );
      logger.warn( "Couldn't determine server's IP" );
    }

    return exchangeValue;
  }
}
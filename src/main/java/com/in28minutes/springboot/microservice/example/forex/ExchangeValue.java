package com.in28minutes.springboot.microservice.example.forex;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ExchangeValue {
  
  @Id
  private Long id;
  
  @Column(name="currency_from")
  private String from;
  
  @Column(name="currency_to")
  private String to;
  
  private BigDecimal conversionMultiple;
  @Transient
  private String ip;
  private int port;
  
  public ExchangeValue() {
    
  }
  

  public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public Long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }
  
  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  @Transient
  public String getIp()
  {
    return ip;
  }

  public void setIp( final String ip )
  {
    this.ip = ip;
  }

}
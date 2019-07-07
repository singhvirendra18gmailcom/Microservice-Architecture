package org.gauri.services.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EXCHANGE_VALUE")
public class ExchangeValue {

	@Id
	private Long id;
	
	@Column(name="CURRENCY_FROM")
	private String from;
	
	@Column(name="CURRENCY_TO")
	private String to;
	private BigDecimal conversionMultiple;
	
	
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	private int port;

	public ExchangeValue() {
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal concersionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = concersionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}



	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}

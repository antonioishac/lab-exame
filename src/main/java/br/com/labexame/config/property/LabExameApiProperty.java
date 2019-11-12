package br.com.labexame.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("labexame")
public class LabExameApiProperty {

	private String originPermitida = "http://localhost:8080";

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

}

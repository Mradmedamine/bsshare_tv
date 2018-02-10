package org.joker.tv.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.apache.commons.lang3.RandomStringUtils;
import org.joker.tv.model.front.web.ComponentStatus;

@MappedSuperclass
public abstract class BaseSubscription extends BaseEntity {

	private String activeCode;
	private LocalDate expiration;
	private ComponentStatus status;
	private Device device;

	{
		status = ComponentStatus.DEACTIVATED;
	}

	@Column(unique = true)
	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	@PrePersist
	void generateActiveCode() {
		activeCode = RandomStringUtils.randomAlphanumeric(10);
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}

	public ComponentStatus getStatus() {
		return status;
	}

	public void setStatus(ComponentStatus status) {
		this.status = status;
	}

	@ManyToOne
	@JoinColumn(name = "device_id")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
}

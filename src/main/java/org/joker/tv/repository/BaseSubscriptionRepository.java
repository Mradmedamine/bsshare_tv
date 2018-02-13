package org.joker.tv.repository;

import java.util.List;

import org.joker.tv.model.entity.BaseSubscription;

public interface BaseSubscriptionRepository {

	List<? extends BaseSubscription> findOneByCriteria(String activeCode, String macAddress, String serial);

	void save(BaseSubscription subscription);

	List<? extends BaseSubscription> findByDevice_SerialNumber(String serial);

}

package de.terrestris.shogun2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import de.terrestris.shogun2.dao.InterceptorRuleDao;
import de.terrestris.shogun2.model.interceptor.InterceptorRule;

/**
 *
 * @author Daniel Koch
 * @author Kai Volland
 * @author terrestris GmbH & Co. KG
 *
 * @param <E>
 * @param <D>
 */
@Service("interceptorRuleService")
public class InterceptorRuleService<E extends InterceptorRule, D extends InterceptorRuleDao<E>>
		extends AbstractExtDirectCrudService<E, D> {

	/**
	 * Default constructor, which calls the type-constructor
	 */
	@SuppressWarnings("unchecked")
	public InterceptorRuleService() {
		this((Class<E>) InterceptorRule.class);
	}

	/**
	 * Constructor that sets the concrete entity class for the service.
	 * Subclasses MUST call this constructor.
	 */
	protected InterceptorRuleService(Class<E> entityClass) {
		super(entityClass);
	}

	/**
	 * 
	 * @param filterMap
	 * @return
	 */
	public List<E> findSpecificRule(Map<String, String> filterMap) {
		return this.dao.findSpecificRule(filterMap);
	}

	/**
	 * We have to use {@link Qualifier} to define the correct dao here.
	 * Otherwise, spring can not decide which dao has to be autowired here
	 * as there are multiple candidates.
	 */
	@Override
	@Autowired
	@Qualifier("interceptorRuleDao")
	public void setDao(D dao) {
		this.dao = dao;
	}

}
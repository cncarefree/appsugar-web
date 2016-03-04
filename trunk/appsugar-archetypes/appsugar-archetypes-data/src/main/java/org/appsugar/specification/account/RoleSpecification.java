package org.appsugar.specification.account;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.appsugar.condition.account.RoleCondition;
import org.appsugar.entity.account.Role;
import org.appsugar.extend.SpecificationQueryWrapper;
import org.appsugar.specification.IdEntitySpecification;

public class RoleSpecification extends IdEntitySpecification<Role, RoleCondition> {

	public RoleSpecification(RoleCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(SpecificationQueryWrapper<Role> query, Root<Role> root, CriteriaBuilder cb,
			RoleCondition condition) {
		super.addCondition(query, root, cb, condition);
		String name = condition.getName();
		if (StringUtils.isNotBlank(name)) {
			Expression<String> nameExpression = root.get(Role._name);
			query.add(cb.like(nameExpression, name + "%"));
		}
		String title = condition.getTitle();
		if (StringUtils.isNotBlank(title)) {
			Expression<String> titleExpression = root.get(Role._title);
			query.add(cb.like(titleExpression, title + "%"));
		}
	}

}

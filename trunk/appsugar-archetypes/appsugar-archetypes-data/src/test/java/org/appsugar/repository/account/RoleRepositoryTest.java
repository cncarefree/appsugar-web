package org.appsugar.repository.account;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.appsugar.BaseJpaDaoTestCase;
import org.appsugar.condition.account.RoleCondition;
import org.appsugar.dto.account.RoleUserDto;
import org.appsugar.entity.account.Role;
import org.appsugar.specification.account.RoleSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author NewYoung
 * 2016年2月23日下午6:50:59
 */
public class RoleRepositoryTest extends BaseJpaDaoTestCase {

	@Autowired
	private RoleRepository repository;

	@Test
	public void testSave() {
		Role role = new Role("testSave", "title");
		repository.saveAndFlush(role);
		Assert.assertNotNull(role.getId());
		logger.debug("test save role id is {}", role.getId());
	}

	@Test
	public void testDeleteRole() {
		Long id = -2l;
		repository.deleteRole(id);
	}

	@Test
	public void testGetRoleStatistic() {
		List<RoleUserDto> roleUserDtoList = repository.getRoleStatistic();
		logger.debug("testGetRoleStatistic result is {}", roleUserDtoList);
		Assert.assertTrue(CollectionUtils.isNotEmpty(roleUserDtoList));
	}

	@Test
	public void testFindRoleStatistic() {
		List<RoleUserDto> roleUserDtoList = repository.findRoleStatistic(-2l);
		logger.debug("testFindRoleStatistic result is {}", roleUserDtoList);
		Assert.assertTrue(CollectionUtils.isNotEmpty(roleUserDtoList));
	}

	@Test
	public void testFindBySpecification() {
		RoleCondition condition = new RoleCondition();
		List<Role> roleList = repository.findAll(new RoleSpecification(condition));
		logger.debug("testFindBySpecification {}", roleList);
		Assert.assertTrue(CollectionUtils.isNotEmpty(roleList));
	}
}

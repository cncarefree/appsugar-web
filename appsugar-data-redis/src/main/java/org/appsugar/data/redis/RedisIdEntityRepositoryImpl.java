package org.appsugar.data.redis;

import java.util.List;

import org.appsugar.bean.condition.StringIdEntityCondition;
import org.appsugar.bean.domain.Page;
import org.appsugar.bean.domain.Pageable;
import org.appsugar.bean.domain.Sort;
import org.appsugar.bean.entity.StringIdEntity;
import org.appsugar.data.common.repository.ext.RepositoryExtension;
import org.appsugar.data.common.repository.ext.RepositoryExtensionable;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.repository.support.SimpleKeyValueRepository;
import org.springframework.data.repository.core.EntityInformation;

/**
 * redis数据访问接口增强实现类
 * @author NewYoung
 * 2016年11月23日下午4:58:29
 */
public class RedisIdEntityRepositoryImpl<T extends StringIdEntity, C extends StringIdEntityCondition>
		extends SimpleKeyValueRepository<T, String>
		implements RedisIdEntityRepository<T, C>, RepositoryExtensionable<String, T, C> {

	protected RepositoryExtension<String, T, C> repositoryExtension;

	public RedisIdEntityRepositoryImpl(EntityInformation<T, String> metadata, KeyValueOperations operations) {
		super(metadata, operations);
	}

	@Override
	public void setRepositoryExtension(RepositoryExtension<String, T, C> repositoryExtension) {
		this.repositoryExtension = repositoryExtension;
	}

	@Override
	public Page<T> findPageByCondition(C condition, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> findByCondition(C condition) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> findByCondition(C condition, Sort sort) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count(C condition) {
		throw new UnsupportedOperationException();
	}
}

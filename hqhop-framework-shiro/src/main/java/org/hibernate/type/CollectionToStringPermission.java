package org.hibernate.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqhop.framework.common.orm.hibernate.type.CollectionToStringUserType;
import com.hqhop.framework.shiro.entity.Permission;
import com.hqhop.framework.shiro.service.PermissionService;

/**
 * 将List转换为指定分隔符分隔的字符串存储 List的元素类型只支持常见的数据类型
 */
public class CollectionToStringPermission extends CollectionToStringUserType {

	@Autowired
	private PermissionService permissionService;

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
		String valueStr = rs.getString(names[0]);
		if (StringUtils.isEmpty(valueStr)) {
			return newCollection();
		}
		String[] values = StringUtils.split(valueStr, this.separator);
		Collection result = newCollection();
		for (String value : values) {
			if (StringUtils.isNotEmpty(value)) {
				result.add(permissionService.findObject(value));
			}
		}
		return result;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
		StringBuffer valueStr = null;
		if (value == null) {
			valueStr = new StringBuffer("");
		} else {
			for (Object o : (Collection) value) {
				Permission permission = (Permission) o;
				valueStr.append(permission.getId()).append(separator);
			}
			valueStr.deleteCharAt(valueStr.length() - 1);
		}
		if (StringUtils.isNotEmpty(valueStr)) {
			valueStr.append(",");
		}
		st.setString(index, valueStr.toString());
	}
}

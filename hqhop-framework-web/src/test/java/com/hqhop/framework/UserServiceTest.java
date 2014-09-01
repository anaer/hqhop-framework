package com.hqhop.framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hqhop.framework.common.utils.SpringUtils;
import com.hqhop.framework.shiro.entity.User;
import com.hqhop.framework.shiro.service.DepartmentService;
import com.hqhop.framework.shiro.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(locations = { "classpath:spring-config.xml" }) })
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @Before
    public void setUp() {
	// System.out.println(SpringUtils.getBean("userServiceImpl11"));
	// userService = SpringUtils.getBean("userServiceImpl11");
    }

    @Test
    public void testService() {
	User user = new User();
	user.setName("taoli");
	user.setPassword("123456");
	user.setAge(24);
	user.setDeleted(false);
	// userService.remove(user);
	// userService.update(user);
	System.out.println(userService.save(user));
	// System.out.println(userService.count());

	// Searchable searchable = Searchable.newSearchable();
	// searchable.addSearchFilter("age", SearchOperator.eq, 21);
	// System.out.println(userService.count(searchable));
	// System.out.println(userService.isExist(searchable));
	// System.out.println(userService.isExist("4028e49c47d381790147d3817d200000"));
	// System.out.println(userService.queryAll());
	// List<String> ids = new ArrayList<String>();
	// ids.add("4028e49c47d381260147d38129570000");
	// ids.add("4028e49c47d37b170147d37b1bfe0000");
	// System.out.println(userService.queryAll(ids));
	// System.out.println(userService.queryAll(searchable));
	// Sort sort = new Sort(Sort.Direction.DESC, "age");
	// System.out.println(userService.queryAll(sort));
	// System.out.println(userService.queryObject(searchable));

	// Pageable pageable = new PageRequest(0, 2, sort);
	// System.out.println(userService.queryPage(pageable).getContent());
	// System.out.println(userService.queryObject("4028e49c47d3ce4d0147d3ce50ec0000"));
	// User user =
	// userService.queryObject("4028e49c47d3ce4d0147d3ce50ec0000");
	// user.setName("dfe");
	// userService.update(user);
	// userService.remove(user);
	// System.out.println(userService.queryObject("4028e49c47d3ce4d0147d3ce50ec0000"));

    }

    @Test
    public void testSql() {
	// System.out.println(userService.findList("select",
	// "4028e49c47d3bf080147d3bf0ba50000"));

	Map<String, String> params = new HashMap<>();
	params.put("id", "4028e4bb47fcbc420147fcbc501e0000");
	System.out.println(userService.findList("select", params));

	// userService.update("update", params);
    }

    @Test
    public void testCache() {
	User user = new User();
	user.setName("silentwuYuerwu");
	user.setPassword("123456");
	user.setAge(24);
	User u = userService.save(user);
	System.out.println(userService.findObject(u.getId()));
    }

    @Test
    public void testUserDepartment() {
	// Department depart = new Department();
	// depart.setName("技术前沿研究所");
	// System.out.println(departmentService.save(depart));
	User user = userService.findObject("4028e4bb47fcbe300147fcbe41180000");
	System.out.println(user);
    }

    @Test
    public void testResource() throws IOException {
	//		UrlResource urlRes = new UrlResource("http://docs.spring.io/spring/docs/4.1.0.RC2/spring-framework-reference/pdf/spring-framework-reference.pdf");
	//		Resource resource = SpringUtils.getResource("http://nb.baidupcs.com/file/c333838ae26b5003311317505c3c0c61?fid=1125129068-250528-410788851827547&time=1409102845&sign=FDTAXER-DCb740ccc5511e5e8fedcff06b081203-dfQEzyKTtL7us69mcyGX9aT3czo%3D&to=nbb&fm=Nin,B,T,t&newver=1&newfm=1&flow_ver=3&expires=1409103445&rt=sh&r=167317567&mlogid=1297224873&sh=1&vuk=1125129068&vbdid=251195064&fn=spring-framework-reference-4.pdf");
	Resource resource = SpringUtils.getResource("classpath:spring-config.xml");
	//		Resource resource = SpringUtils.getResource("file:/spring-config.xml");
	System.out.println(resource.getFilename());
	System.out.println(resource.getDescription());

	File file = new File("c:/" + resource.getFilename());
	FileOutputStream fos = new FileOutputStream(file);
	IOUtils.copy(resource.getInputStream(), fos);

	fos.close();
    }

}

# Noob-program-
这个版本是学习了当前较为流行的一些框架Spring和Mabatis整合而成的一个项目。

项目大体的模块还是由上一个版本构成。
登录-菜单-权限-数据增删查改这样一个简单的项目
目的主要是学习了框架后，结合到实际的项目中的一些应用，虽然也有一些其他框架整合而成的版本，但大体是一个项目的改动，这里就不再引入。

简单说说这个项目的技术覆盖，项目使用的Maven控制Jar包版本依赖关系，使用的IDE为IDEA
框架使用Springmvc、Spring、Mabatis（SSM）

技术重点与难点
    --动态菜单
          根据登录的角色动态生成相应的菜单，菜单的生成涉及到角色与菜单连个表的对应关系，两个表的关系通过建立第三个表（中间表）来建立联系。
          设定管理员拥有全部的菜单操作权限，其他的角色酌情的可以分配一些菜单操作。
          
          具体的实现：简单的口述一下，首先得谈及到数据库的设计，数据库中又一个User表，很直白 这个表就是用户记录表，用户登录的操作是从该表中获取数据，表中有RoleId这么一个字段，这个字段是外键关联的是Role表，那么这样在用户实现登录的情况下就能获知该用户的角色，也可以说是其所拥有的权限级别。接着通过角色与菜单中间表的巧妙设计不难获得该角色所对应的菜单。
          
     //查询当前用户的角色(权限)
				List<Menu> uList = menudao.getMenusByRoleId(u.getRoleId());
				
				//<父菜单对象，父菜单对应下的子菜单集合>
				Map<Menu,List<Menu>> map = new TreeMap<Menu,List<Menu>>();
				//装父菜单的临时map<父菜单ID,父菜单对象>
				Map<Long,Menu> temp = new HashMap<Long,Menu>();
				for (Menu menu : uList) {
					if(menu.getMlevel()==1){//一级菜单
						//System.out.println(menu);
						temp.put(menu.getId(),menu);
						map.put(menu,new ArrayList<Menu>());
					}
				}
				
				for (Menu menu : uList) {
					if(menu.getMlevel()==2){
						Menu pm = temp.get(menu.getPid());//父菜单对象
						List<Menu> sList = map.get(pm);//根据父菜单对象获取装它对应子菜单的集合
						if(sList!=null){
							sList.add(menu);
						}
					}
				}

	--权限分配
          该功能暂时并没有做到非常完善的程度，只是勉强的实现了一个概念性的功能。不同的角色之间拥有不同的系统操作权限，目前可能只是凸显在菜单的操作上，对于实际的细节操作并没有再做其他的限制。若需要深入，我想需要从数据库设计着手，增加一些细节操作的管理表。
	  权限的具体展示再页面中是以树状图显示，如何去实现的，则是先将所有的菜单获取，再将该角色所拥有的菜单获取，两个数据均存放在list中，还需提一嘴的是POJO中增加一个Checked，通过比较，重复的则为选中，反之则未选中。
	  
	  // 临时变量(用于判断哪个菜单当前角色已拥有)
		List<Long> menuIds = new ArrayList<Long>();
		for (Menu m : list2) {
			menuIds.add(m.getId());
		}
		// 在角色拥有的菜单权限上做标记
		for (Menu o : list1) {
			if (menuIds.contains(o.getId())) {
				o.setChecked(true);
			} else {
				o.setChecked(false);
			}
		}

	

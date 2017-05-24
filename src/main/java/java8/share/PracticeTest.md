#查询数据库

```
    public List<ArticleDBInfo> findArticleByIds(List<String> ids) {
        if (null == ids || ids.isEmpty()) {
            return Collections.emptyList();
        }
        String placeHolders = ids.stream().map(id -> "?").collect(Collectors.joining(","));

        return jdbcTemplate.query("SELECT id, title FROM cms_article WHERE id IN (" + placeHolders + ")", ids.toArray(),new ArticleRowMapper());
    }

```

#枚举

```
public enum Business {

    //门店管理中维护的ID
    O2O(1,"多点超市"),
    //门店管理中维护的ID
    GLOBAL(2,"全球精选"),
    //门店管理中维护的ID
    OVERSEAS(3,"海淘"),
    //门店管理中维护的ID
    WAIMAI(5,"外卖"),
    //门店管理中维护的ID
    NEXT_DAY(6,"半日达");
    
    private int id;
    private String name;
    Business(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Map<Integer,String> toMap(){
        return Stream.of(Business.values())
                    .collect(Collectors
                            .toMap(b -> b.id, b -> b.name));
    }
}

```

#dmall员工最老的10个员工(取top10)

```
        List<Person> top10 = persons.stream()
                .sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()))
                .limit(10)
                .collect(Collectors.toList());
               
```

#dmall男女平均年龄

```
		persons.stream()
				.collect(Collectors.groupingBy(p -> p.getGender(), 
								Collectors.averagingInt(p -> p.getAge())))

```

#实体集合 到 实体ID集合

```
		ShopRule sr = new ShopRule();
		sr.setShopId(storeId);
		sr.setYn(YnEnum.Y.getKey());
		List<ShopRule> shopRuleList = shopRuleDao.selectEntryList(sr);
		List<String> ruleIds = Optional.ofNullable(shopRuleList)
									.orElseGet(Collections::emptyList)
									.stream()
									.map(sr -> sr.getId())
									.collect(Collectors.toList());
		List<DeliverycostRule> ruleList = deliverycostRuleDao.selectEntryList(ruleIds);
		}
				
```

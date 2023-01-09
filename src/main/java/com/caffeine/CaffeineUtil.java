package com.caffeine;

//public class CaffeineUtil {
//
//
//
//
//
//
//
//}
//
////阅读即焚 - 设置缓存时间
//class v1{
//    public static void main(String... args) throws Exception {
//        Cache<String, String> cache = Caffeine.newBuilder()
//                //5秒没有读写自动删除
//                .expireAfterAccess(5, TimeUnit.SECONDS)
//                //最大容量1024个，超过会自动清理空间
//                .maximumSize(1024)
//                .removalListener(((key, value, cause) -> {
//                    //清理通知 key,value ==> 键值对   cause ==> 清理原因
//                }))
//                .build();
//
//        //添加值
//        cache.put("张三", "浙江");
//        Thread.sleep(3000);
//        //获取值
//        String a = cache.getIfPresent("张三");
//
//        Thread.sleep(5000);
//        String b = cache.getIfPresent("张三");
//        System.out.println(a);
//        System.out.println(b);
//        //remove
//        //cache.invalidate("张三");
//    }
//}
//
////手动存，获取一个key，如果key没有值，就直接执行 k 里的函数填充
//class v2{
//    public static void main(String... args) throws Exception {
//        Cache<String, Integer> cache = Caffeine.newBuilder().build();
//
//        Integer age1 = cache.getIfPresent("张三");
//        System.out.println(age1);
//
//        //cache.put("张三",2);
//
//        //当key不存在时，会立即创建出对象来返回，age2不会为空
//        Integer age2 = cache.get("张三", k -> {
//            System.out.println("k:" + k);
//            return 18;
//        });
//        System.out.println(age2);
//
//    }
//}
//
////触发填充，第一次获取为null，再次获取就会执行 key对应的createExpensiveGraph方法填充
//class v3{
//    public static void main(String... args) throws Exception {
//
//        //此时的类型是 LoadingCache 不是 Cache
//        LoadingCache<String, Integer> cache = Caffeine.newBuilder().build(key -> {
//            System.out.println("自动填充:" + key);
//            return 18;
//        });
//
//        Integer age1 = cache.getIfPresent("张三");
//        System.out.println(age1);
//
//        // key 不存在时 会根据给定的CacheLoader自动装载进去
//        Integer age2 = cache.get("张三");
//        System.out.println(age2);
//    }
//}
//
////自动填充
//class v4{
//    public static void main(String... args) throws Exception {
//
//        //此时的类型是 LoadingCache 不是 Cache
//        LoadingCache<String, Integer> cache = Caffeine.newBuilder().build(key -> {
//            System.out.println("自动填充:" + key);
//            return 18;
//        });
//
//        Integer age1 = cache.getIfPresent("张三");
//        System.out.println(age1);
//
//        // key 不存在时 会根据给定的CacheLoader自动装载进去
//        Integer age2 = cache.get("张三");
//        System.out.println(age2);
//    }
//}
//
//class v5{
//    public static void main(String... args) throws Exception {
//        AsyncCache<String, Integer> cache = Caffeine.newBuilder().buildAsync();
//
//        //会返回一个 future对象， 调用future对象的get方法会一直卡住直到得到返回，和多线程的submit一样
//        CompletableFuture<Integer> ageFuture = cache.get("张三", name -> {
//            System.out.println("name:" + name);
//            return 18;
//        });
//
//        Integer age = ageFuture.get();
//        System.out.println("age:" + age);
//    }
//}
//
//class v6{
//    public static void main(String... args) throws Exception {
//        //和4基本差不多
//        AsyncLoadingCache<String, Integer> cache = Caffeine.newBuilder().buildAsync(name -> {
//            System.out.println("name:" + name);
//            return 18;
//        });
//        CompletableFuture<Integer> ageFuture = cache.get("张三1");
//
//        Integer age = ageFuture.get();
//        System.out.println("age:" + age);
//    }
//}

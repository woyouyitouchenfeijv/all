package com.caffeine;

/**
 * @Author dx
 * @Description
 * @Date 2022/6/30
 */
public class CaffeineUtil2 {
//    //缓存map
//    LoadingCache<String, Map<String, String>> cache;
//    //给map刷新数据的方法
//    private RunnableWorkInterface rk;
//    //存在map里的key
//    private String cacheKey;
//
//
//    //TODO 要改成线程池
//    //刷新map的线程
//    Runnable doWork = new Runnable() {
//        @Override
//        public void run() {
//            try {
//               // Map<String, String> map = rk.initWorkMap();
//                //cache.put(cacheKey, map);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    };
//
//
//    //CaffeineUtil主方法
//    public CaffeineUtil2(RunnableWorkInterface work,String key,int initialDelay,int delay){
//        if(work == null || StringHelper.isEmpty(key)){
//            return;
//        }
//        rk = work;
//        cacheKey = key;
//        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
//        /**
//         * command - 要执行的任务
//         * initialDelay - 首次执行的延迟时间
//         * delay - 一次执行终止和下一次执行开始之间的延迟
//         * unit - initialDelay 和 delay 参数的时间单位
//         */
//        scheduler.scheduleWithFixedDelay(doWork, initialDelay, delay, TimeUnit.SECONDS);
//        cache = Caffeine.newBuilder()
//                // 自定义线程池异步执行
//                .scheduler(Scheduler.forScheduledExecutorService(scheduler))
//                .build(new CacheLoader<String, Map<String, String>>() {
//                    @Override
//                    public Map<String, String> load(String key){
//                        Map<String, String> map = new HashMap<>();
//                        System.out.println("第一次从缓存拿到，放到map");
//                        return map;
//                    }
//                });
//    }
//
//}
//
//class Test implements RunnableWorkInterface{
//    public static void main(String[] args) throws InterruptedException {
//
//        Thread thread1 = new Thread(() -> {
//            Test t = new Test();
//            CaffeineUtil2 caffeineUtil = new CaffeineUtil2(t,"dictCode",13,5);
//            LoadingCache<String, Map<String, String>> cache = caffeineUtil.cache;
//            while (true) {
//                Map<String, String> stringStringMap = caffeineUtil.cache.get("dictCode");
//                System.out.println(stringStringMap);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            Test2 t = new Test2();
//            CaffeineUtil2 caffeineUtil = new CaffeineUtil2(t,"dictCode2",13,5);
//            LoadingCache<String, Map<String, String>> cache = caffeineUtil.cache;
//            while (true) {
//                Map<String, String> stringStringMap = caffeineUtil.cache.get("dictCode2");
//                System.out.println(stringStringMap);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        //thread1.start();
//        thread2.start();
//
//    }
//
//    @Override
//    public Map initWork() {
//        Map map = new HashMap();
//        map.put("3","3");
//        return map;
//    }
//
//}
//
//class Test2 implements RunnableWorkInterface{
//
//    @Override
//    public Map initWork() {
//        Map map = new HashMap();
//        System.out.println("从缓存更新");
//        map.put("4","4");
//        return map;
//    }
}
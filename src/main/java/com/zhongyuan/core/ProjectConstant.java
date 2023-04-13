package com.zhongyuan.core;

/**
 * 项目常量
 */
public final class ProjectConstant {

    /**
     * 项目基础包名称，根据自己公司的项目修改
     */
    public static final String BASE_PACKAGE = "com.zhongyuan";


    public static final String BASE_PATH = System.getProperty("user.dir") +  "/src/main/java/" + BASE_PACKAGE.replace(".","/");

    /**
     * Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".bean";

    /**
     * Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";

    /**
     * Service所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    /**
     * ServiceImpl所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    /**
     * Controller所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";

    /**
     * 项目model组
     */
    public static final String MODEL_PACKAGE_S = BASE_PACKAGE + ".bean";

    /**
     * 项目mapper组
     */
    public static final String MAPPER_PACKAGE_S = BASE_PACKAGE + ".mapper";


}

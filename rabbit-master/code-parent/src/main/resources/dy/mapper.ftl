<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.${package}.mapper.${table.className}Mapper">

    <select id="get${table.className}ById" resultType="cn.${package}.model.po.${table.className}">
        select
        <#list table.cloumns as cloumn>
            <#if cloumn_has_next>
                ${cloumn.cloumnName} as ${cloumn.fieldName},
            <#else>
                ${cloumn.cloumnName} as ${cloumn.fieldName}
            </#if>
        </#list>
        from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
            <if test="id != null">
                and id=${r"#{id}"}
            </if>
        </trim>
    </select>

    <select id="get${table.className}ListByMap" resultType="cn.${package}.model.po.${table.className}"
            parameterType="java.util.Map">
        select
        <#list table.cloumns as cloumn>
            <#if cloumn_has_next>
                ${cloumn.cloumnName} as ${cloumn.fieldName},
            <#else>
                ${cloumn.cloumnName} as ${cloumn.fieldName}
            </#if>
        </#list>
        from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
            <#list table.cloumns as cloumn>
                <#if cloumn.cloumnType=='BIGINT' || cloumn.cloumnType=='INT'>
                    <if test="null!=${cloumn.fieldName} and ''!=${cloumn.fieldName} ">
                        and ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}}
                    </if>
                <#else>
                    <if test="${cloumn.fieldName} != null and ${cloumn.fieldName}!=''">
                        and ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}}
                    </if>
                </#if>
            </#list>
        </trim>
        <if test="beginPos != null and pageSize != null ">
            limit ${r"#{"}beginPos},${r"#{"}pageSize}
        </if>
    </select>

    <select id="get${table.className}CountByMap" resultType="Integer" parameterType="java.util.Map">
        select count(*) from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
            <#list table.cloumns as cloumn>
                <#if cloumn.cloumnType=='BIGINT' || cloumn.cloumnType=='INT'>
                    <if test="null!=${cloumn.fieldName} and ''!=${cloumn.fieldName} ">
                        and ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}}
                    </if>
                <#else>
                    <if test="${cloumn.fieldName} != null and ${cloumn.fieldName}!=''">
                        and ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}}
                    </if>
                </#if>
            </#list>
        </trim>
    </select>

    <insert id="insert${table.className}" parameterType="cn.${package}.model.po.${table.className}">
        insert into ${table.tableName}(
        <#list table.cloumns as cloumn>
            <#if cloumn_has_next>
                <#if  cloumn.cloumnName!='id'>
                    ${cloumn.cloumnName},
                </#if>
            <#else>
                <#if  cloumn.cloumnName!='id'>
                    ${cloumn.cloumnName})
                </#if>
            </#if>
        </#list>
        values(
        <#list table.cloumns as cloumn>
            <#if cloumn_has_next>
                <#if  cloumn.cloumnName!='id'>
                    ${r"#{"}${cloumn.fieldName}},
                </#if>
            <#else>
                <#if  cloumn.cloumnName!='id'>
                    ${r"#{"}${cloumn.fieldName}})
                </#if>
            </#if>
        </#list>
    </insert>

    <update id="update${table.className}" parameterType="cn.${package}.model.po.${table.className}">
        update ${table.tableName}
        <trim prefix="set" suffixOverrides="," suffix="where id=${r"#{"}id}">
            <#list table.cloumns as cloumn>
                <#if cloumn_has_next>
                    <#if  cloumn.cloumnName!='id'>
                        <#if cloumn.cloumnType=='BIGINT' || cloumn.cloumnType=='INT'>
                            <if test="null!=${cloumn.fieldName}">
                                ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}},
                            </if>
                        <#else>
                            <if test="${cloumn.fieldName} != null and ${cloumn.fieldName}!=''">
                                ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}},
                            </if>
                        </#if>
                    </#if>
                <#else>
                    <#if  cloumn.cloumnName!='id'>
                        <#if cloumn.cloumnType=='BIGINT' || cloumn.cloumnType=='INT'>
                            <if test="null!=${cloumn.fieldName}">
                                ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}}
                            </if>
                        <#else>
                            <if test="${cloumn.fieldName} != null and ${cloumn.fieldName}!=''">
                                ${cloumn.cloumnName}=${r"#{"}${cloumn.fieldName}}
                            </if>
                        </#if>
                    </#if>
                </#if>
            </#list>
        </trim>
    </update>

    <delete id="delete${table.className}ById" parameterType="String">
        delete from ${table.tableName} where id = ${r"#{"}id}
    </delete>

    <delete id="batchDelete${table.className}" parameterType="java.util.Map">
        delete from ${table.tableName} where id in (
        <foreach collection="ids" item="id" separator=",">
            ${r"#{"}id}
        </foreach>
        )
    </delete>
</mapper>
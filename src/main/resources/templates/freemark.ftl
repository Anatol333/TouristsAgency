<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test1 page</title>
    <#--<link href="/css/main.css" rel="stylesheet">-->
</head>
<body>
<ul>
    <#if users?has_content>
        <#list users as user>
            <li>${user.id} ${user.username}</li>
        </#list>
    <#else> Users list is empty!
    </#if>
</ul>

<#--<script src="/js/main.js"></script>-->
</body>
</html>
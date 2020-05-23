<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dto??>
        <a href="/" style="margin-right: 20px">Главная</a><a href="/createNewForm" style="margin-right: 20px">Создать тему</a><input placeholder="Поиск по названию" style="margin-right: 20px"><a href="/room" style="margin-right: 20px">Личный кабинет</a>
        <form class="flex box-128" action="/logout" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <button>Выйти</button>
        </form>
        <#list form as form>
            <hr style="margin-top: 5px">
            <form>
            <a href="/theme/${form.id}"><strong style="margin-right: 50px">${form.name}</strong><strong style="margin-right: 50px">${form.date}</strong><strong style="margin-right: 50px">${form.customer.getName()}</strong></a>
            </form>
            <hr>
        </#list>
    <#else>
        <h1>Пользователь не найден!</h1>
    </#if>
</@main.renderWith>
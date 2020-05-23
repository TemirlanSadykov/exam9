<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <form id="createNewForm" action="/createNewForm" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <p>Введите название темы</p>
        <input name="name">
        <p>Введите описание темы</p>
        <textarea name="description"></textarea>
        <p>Введите ваше имя</p>
        <input name="customer">
        <button type="submit">Сохранить</button>
    </form>
</@main.renderWith>
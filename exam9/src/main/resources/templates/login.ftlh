<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Please sign in</h2>
    <form action="/login" method="post">

        <#if errors??>
            <div>
                <p>${errors!'-- no message --'}</p>
            </div>
        </#if>
        <div>
            <#if error!false >
                <p style="color:red">Неверные имя пользователя или пароль !</p>
            </#if>
        </div>

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center ">
                <span class="label-input-text">Адрес почты:</span>
                <input type="text" name="username" placeholder="ваш адрес почты" value="${(dto.email)!''}" autofocus>
            </label>
        </div>
        <div>
            <label class="flex flex-v-center label-input-text">
                <span class="label-input-text">Пароль:</span>
                <input type="password" name="password" placeholder="пароль" value="">
            </label>
        </div>
        <div>
            <button type="submit">Войти!</button>
        </div>
        <div style="margin: 20px 0">
            <a class="flex box-128" href="/forgot"> Забыли пароль? </a><br>
        </div>
    </form>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>

<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Enter your email to reset password</h2>
    <#if errors??>
        <div>
            <p>${errors!'-- no message --'}</p>
        </div>
    </#if>
    <div>
        <form action="/reset-password" method="post">

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Токен:</p>
                    <input type="text" name="token" placeholder="Токен">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Новый пароль:</p>
                    <input type="password" name="newPassword" placeholder="Новый пароль">
                </label>
            </div>
            <div>
                <button type="submit">Отправить</button>
            </div>
        </form>
    </div>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>
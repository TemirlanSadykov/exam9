<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Enter your email to reset password</h2>
    <div>
        <form action="/forgot" method="post">

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Адрес почты:</p>
                    <input type="text" name="email" placeholder="Почта">
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
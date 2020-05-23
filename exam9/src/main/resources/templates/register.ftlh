<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2>Please register</h2>
    <div>
        <form action="/register" method="post">

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Имя:</p>
                    <input type="text" name="name" placeholder="Имя" value="${(dto.name)!''}">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Логин:</p>
                    <input type="text" name="login" placeholder="Логин" value="${(dto.login)!''}">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Адрес почты:</p>
                    <input type="text" name="email" placeholder="Почта" value="${(dto.email)!''}">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text">Пароль:</p>
                    <input type="password" name="password" placeholder="Пароль" value="${(dto.password)!''}">
                </label>
            </div>
            <div>
                <button type="submit">Регистрация</button>
            </div>
            <div>
                <#if errors?? >
                    <p>Входные данные с ошибками!</p>
                    <#list errors as fieldError>
                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                    </#list>
                </#if>
            </div>
        </form>
    </div>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>

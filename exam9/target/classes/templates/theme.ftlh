<#import "partials/main.ftlh" as main />

<@main.renderWith>
        <hr style="margin-top: 5px">
        <form>
                <strong style="margin-right: 50px">${theme.name}</strong><strong style="margin-right: 50px">${theme.date}</strong><strong style="margin-right: 50px">${theme.customer.getName()}</strong>
        </form>
        <hr>
        <p>${theme.description}</p>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                Оставить комментарий
        </button>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                        <div class="modal-content">
                                <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Ваш комментарий</h5>
                                </div>
                                <div class="modal-body">
                                        <form id="commentForm" action="/comment" method="post">
                                                <#if _csrf??>
                                                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                                                </#if>
                                                <input type="hidden" name="form" value="${theme.name}">
                                                <p><input placeholder="Введите ваше имя" name="name"></p>
                                                <p><textarea placeholder="Введите комментарий" name="comment"></textarea></p>
                                                <button type="submit">Оставить комментарий</button>
                                        </form>
                                </div>
                        </div>
                </div>
        </div>
        <#list comment as comment>
                <hr>
                <form>
                        <h3><span style="margin-right: 20px">${comment.customer.name}</span><span>${comment.date}</span></h3>
                        <p>${comment.comment}</p>
                </form>
                <hr>
        </#list>

</@main.renderWith>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<%@ page pageEncoding="UTF-8"%>
<jsp:include page="/templates/jstl.jsp" />

		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="brand" href="#">Spring Camel</a>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="active"><a href="${ctx}/projetos">Projetos</a></li>
							<li><a href="${ctx}/Alterar senha">Alterar senha</a></li>
						</ul>
						<ul class="nav pull-right">
	                      <li><a href="#"><span class="badge badge-success">${usuarioWeb.usuario.login }</span></a></li>
	                      <li class="divider-vertical"></li>
	                      <li><a href="${ctx }/logout">Sair</a></li>
	                    </ul>
					</div>
				</div>
			</div>
		</div>
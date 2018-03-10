<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'affectation.label', default: 'Affectation')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-affectation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <g:form action="afficherListe">
                 <fieldset class="form">
                     <div class='fieldcontain'>
                        <label for='selectFormation'>Formation</label>
                        <g:select name="selectFormation" id="selectFormation" from="${listeFormations}" optionValue="nomformation"  noSelection="['':'']"/>
                     </div>
                    <div class='fieldcontain'>
                        <label for='selectPersonne'>Personne</label>
                        <g:select name="selectPersonne" id="selectPersonne" from="${listePersonne}" value="${listePersonneSelected}"  multiple='true'  optionValue="nom"  noSelection="['':'']"/>
                    </div>
                    <div class='fieldcontain'>
                       <label for='submit'></label>
                        <g:submitButton name="submit"/>
                    </div>
                 </fieldset>
                </g:form>
           </ul>
        </div>
    </body>
</html>
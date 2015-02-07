<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th class="col-md-2">Key</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${data?.keySet()}" var="resp">
        <tr>
            <td>${resp}</td>
            <td>${raw(data[resp])}</td>
        </tr>
    </g:each>
    </tbody>
</table>
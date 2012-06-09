Sys.Application.add_load(AppLoad);

function SelectAllCheckboxes(Chk, grupo) {
    var theBox = Chk;
    xState = theBox.checked;

    elm = theBox.form.elements;
    for (i = 0; i < elm.length; i++)
        if ((elm[i].type == "checkbox") && (elm[i].id != theBox.id) && (elm[i].id.indexOf(grupo) != -1)) {
            if (elm[i].checked != xState)
                elm[i].checked = xState;
        }
}

function showError(msg) {
    if ($get('Error') != null) {
        $get('Error').innerHTML = msg;
    }
}

function AppLoad() {
    Sys.WebForms.PageRequestManager.getInstance().add_endRequest(EndRequest);
    Sys.WebForms.PageRequestManager.getInstance().add_beginRequest(BeginRequest);
}

function BeginRequest(sender, args) {
    // Clear the error if it's visible from a previous request.
    if ($get('Error') != null) {
        $get('Error').innerHTML = "";
    }
}

function EndRequest(sender, args) {
    // Check to see if there's an error on this request.
    if (args.get_error() != undefined) {
        // If there is, show the custom error.
        var msg = args.get_error().message.replace('Sys.WebForms.PageRequestManagerServerErrorException: ', '');
        showError(msg);

        // Let the framework know that the error is handled, 
        //  so it doesn't throw the JavaScript alert.
        args.set_errorHandled(true);
    }
}
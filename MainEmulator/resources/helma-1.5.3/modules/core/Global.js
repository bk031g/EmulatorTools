/*
 * Helma License Notice
 *
 * The contents of this file are subject to the Helma License
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://adele.helma.org/download/helma/license.txt
 *
 * Copyright 1998-2005 Helma Software. All Rights Reserved.
 *
 * $RCSfile: Global.js,v $
 * $Author: tobi $
 * $Revision: 1.1 $
 * $Date: 2006/08/06 11:27:56 $
 */


app.addRepository("modules/core/String.js");


/**
 * write out a property contained in app.properties
 * @param Object containing the name of the property
 */
function property_macro(param) {
    res.write(app.properties[param.name] || String.NULL);
    return;
}


/**
 * wrapper to output a string from within a skin
 * just to be able to use different encodings
 * @param Object containing the string as text property
 */
function write_macro(param) {
    res.write(param.text || String.NULL);
    return;
}


/**
 * renders the current datetime
 * @param Object containing a formatting string as format property
 */
function now_macro(param) {
    var d = new Date();
    if (param.format) {
        res.write(d.format(param.format));
    } else if (param.as == "timestamp") {
        res.write(d.getTime());
    } else {
        res.write(d);
    }
    return;
}


/**
 * renders a global skin
 */
function skin_macro(param) {
    if (param.name) {
        renderSkin(param.name);
    }
    return;
}

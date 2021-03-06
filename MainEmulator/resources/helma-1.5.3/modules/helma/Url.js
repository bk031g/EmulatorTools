/*
 * Helma License Notice
 *
 * The contents of this file are subject to the Helma License
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://adele.helma.org/download/helma/license.txt
 *
 * Copyright 1998-2006 Helma Software. All Rights Reserved.
 *
 * $RCSfile: Url.js,v $
 * $Author: czv $
 * $Revision: 1.2 $
 * $Date: 2006/04/24 07:02:17 $
 */


if (!global.helma) {
    global.helma = {};
}

helma.Url = function(str) {
    if (!str || !helma.Url.PATTERN.test(str))
        throw Error("Cannot create helma.Url: insufficient arguments");

    // filter punctuation from user-generated urls
    // FIXME: a) can this be done in helma.Url.PATTERN?
    //        b) should it be done rather in methods like activateUrls?
    str = str.replace(/[,.;:]\s/, "");

    var parts = helma.Url.PATTERN.exec(str);
    this.protocol = parts[1];

    if (!parts[2]) {
        if (parts[3])
            this.user = parts[3];
    } else {
        this.user = parts[2];
        if (parts[3])
            this.password = parts[3];
    }

    if (!parts[4])
        throw Error("Cannot create helma.Url: missing host part");

    this.domainName = parts[4]; // actually, the fully-qualified domain name
    var fqdnParts = this.domainName.split(".");
    if (fqdnParts.length < 3)
        this.host = "";
    else {
        this.host = fqdnParts[0];
        fqdnParts.splice(0, 1);
    }
    this.topLevelDomain = fqdnParts[fqdnParts.length-1];
    this.domain = fqdnParts.join(".");

    this.pathString = parts[5] || "";
    if (this.pathString.indexOf("/") == 0)
        this.pathString = this.pathString.substring(1);
    this.path = this.pathString.split("/");
    this.file = this.path.pop();

    if (parts[6]) {
        this.queryString = parts[6];
        var pairs;
        this.query = {};
        parts = parts[6].split("&");
        for (var i in parts) {
            pairs = parts[i].split("=");
            this.query[pairs[0]] = pairs[1];
        }
    }

    return this;
};


helma.Url.PATTERN = /^([^:]*):\/\/+(?:([^\/]*):)?(?:([^\/]*)@)?([\w\-_.]*[^.])(\/[^?]*)?(?:\?(.*))?$/;

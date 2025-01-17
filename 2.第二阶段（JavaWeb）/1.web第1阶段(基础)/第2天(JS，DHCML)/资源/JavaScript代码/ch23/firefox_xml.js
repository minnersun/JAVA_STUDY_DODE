var xmlDoc;
function createXMLDoc(XMLHandler){
//load xml file
// code for IE
if (window.ActiveXObject){
  xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
  xmlDoc.onreadystatechange =XMLHandler;
  
  }
// code for Mozilla, Firefox, Opera, etc.
else if (document.implementation && document.implementation.createDocument){
  xmlDoc=document.implementation.createDocument("","",null);
  xmlDoc.onload=XMLHandler;
  }
else  {
  alert('Your browser cannot handle this script');
  }
}




var getNodeValue = function(obj){
    var str = "";
    if(window.ActiveXObject){    //IE
        str = obj.text;
    }else{//Mozilla 
        try{
            str = obj.childNodes[0].nodeValue;
        }catch(ex){
            str = "";
        }
    }
    return str;
}

if(document.implementation && document.implementation.createDocument){
    XMLDocument.prototype.loadXML = function(xmlString){
        var childNodes = this.childNodes;
        for (var i = childNodes.length - 1; i >= 0; i--)
            this.removeChild(childNodes[i]);

        var dp = new DOMParser();
        var newDOM = dp.parseFromString(xmlString, "text/xml");
        var newElt = this.importNode(newDOM.documentElement, true);
        this.appendChild(newElt);
    };

    // check for XPath implementation
    if( document.implementation.hasFeature("XPath", "3.0") ){
       // prototying the XMLDocument
       XMLDocument.prototype.selectNodes = function(cXPathString, xNode){
          if( !xNode ) { xNode = this; }
          var oNSResolver = this.createNSResolver(this.documentElement)
          var aItems = this.evaluate(cXPathString, xNode, oNSResolver,
                       XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null)
          var aResult = [];
          for( var i = 0; i < aItems.snapshotLength; i++){
             aResult[i] =  aItems.snapshotItem(i);
          }
          return aResult;
       }

       // prototying the Element
       Element.prototype.selectNodes = function(cXPathString){
          if(this.ownerDocument.selectNodes){
             return this.ownerDocument.selectNodes(cXPathString, this);
          }
          else{throw "For XML Elements Only";}
       }
    }

    // check for XPath implementation
    if( document.implementation.hasFeature("XPath", "3.0") ){
       // prototying the XMLDocument
       XMLDocument.prototype.selectSingleNode = function(cXPathString, xNode){
          if( !xNode ) { xNode = this; }
          var xItems = this.selectNodes(cXPathString, xNode);
          if( xItems.length > 0 ){
             return xItems[0];
          }else{
             return null;
          }
       }
      
       // prototying the Element
       Element.prototype.selectSingleNode = function(cXPathString){   
          if(this.ownerDocument.selectSingleNode){
             return this.ownerDocument.selectSingleNode(cXPathString, this);
          }
          else{throw "For XML Elements Only";}
       }
    }
}
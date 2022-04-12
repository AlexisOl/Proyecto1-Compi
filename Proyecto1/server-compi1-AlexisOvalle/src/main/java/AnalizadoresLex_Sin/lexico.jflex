package AnalizadoresLex_Sin;
import AnalizadoresLex_Sin.sym;
import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
import Objects.Token;
%%
%class Lexico
%unicode
%line
%column
%cup
%public
%{
    List<Token> listComments =  new ArrayList<>();
    private void addComments(){
        listComments.add(new Token((yyline+1),(yycolumn+1),yytext()));
    }
   
    public List<Token>  getlistComments(){
        return this.listComments;
    };
%}


CARACTER =  [a-zA-Z] | _  
ID = {CARACTER} ({CARACTER} | {ENTERO})*
STRINGTEXT = "\"" ~"\""
OR = ('\u007c')|('|')|("|")|('\u007c')
ENTERO = [+|-]? ([0]|[1-9][0-9]*)
DECIMAL = {ENTERO}[.]{ENTERO}
espacio =[\n | \r | \t | \f | \b]+
/*atributos basicos  ---------------------------------*/
PUNTO = "."
COMA = ","
DOSPUNTOS=":"
PUNTOCOMA=";"
COMILLA = "\""
COMILLA_SIMPLE = "'"


/*Tipos de datos  ---------------------------------*/
INT = "int"
BOOLEAN = "boolean"
STRING = "String"
CHAR = "char"
DOUBLE = "double"
OBJETOS = "Object"
TRUE = "true"
FALSE = "false"

/*-----------------*/
PACKAGE = "package"
IMPORT ="import"
CLASS = "class"
THIS="this" 
/*Sentencias de control  ---------------------------------*/
IF = "if"
ELSE = "else"
FOR = "for"
WHILE = "while"
DO = "do"
SWITCH = "switch"
CASE = "case"
/*SENTENCIAS DE SALIDA   ---------------------------------*/

BREAK = "break"
RETURN = "return"
/*RELACIONALES  ---------------------------------*/
IGUALCOMPARACION = "=="
DISTINTOCOMPARACION = "!="
MAYORQUE = ">"
MENORQUE = "<"
MAYORIGUAL_QUE = ">="
MENORIGUAL_QUE = "<="

/*constructores  ---------------------------------*/
VOID = "void"
/*visibilidad de variables y clases  ---------------------------------*/
PRIVATE = "private"
PUBLIC = "public"
PROTECTED = "protected"
FINAL = "final"

/*LOGICOS  ---------------------------------*/
AND = "&&"
/*DE AGRUPACION  ---------------------------------*/
PARENTESISABIERTO = "("
PARENTESISCERRADO = ")"
LLAVESABIERTO = "{"
LLAVESCERRADO = "}"
CORCHETEABIERTO = "["
CORCHETECERRADO = "]"
%%


{INT}               {return new Symbol(sym.INT,yyline,yycolumn, (yytext())); }
{CHAR}              {return new Symbol(sym.CHAR,yyline,yycolumn, (yytext())); }
{BOOLEAN}           {return new Symbol(sym.BOOLEAN,yyline,yycolumn, (yytext())); }
{STRING}            {return new Symbol(sym.STRING,yyline,yycolumn, (yytext())); }
{TRUE}              {return new Symbol(sym.TRUE,yyline,yycolumn, (yytext())); }
{FALSE}             {return new Symbol(sym.FALSE,yyline,yycolumn, (yytext())); }


{PACKAGE}           {return new Symbol(sym.PACKAGE,yyline,yycolumn, (yytext())); }
{IMPORT}            {return new Symbol(sym.IMPORT,yyline,yycolumn, (yytext())); }
{CLASS}             {return new Symbol(sym.CLASS,yyline,yycolumn, (yytext())); }
{THIS}              {return new Symbol(sym.THIS,yyline,yycolumn, (yytext())); }
"extends"           {return new Symbol(sym.EXNTENDS,yyline,yycolumn, (yytext())); }
"implements"        {return new Symbol(sym.IMPLEMENTS,yyline,yycolumn, (yytext())); }
"super"             {return new Symbol(sym.SUPER,yyline,yycolumn, (yytext())); }
"new"               {return new Symbol(sym.NEW,yyline,yycolumn, (yytext())); }
{VOID}              {return new Symbol(sym.VOID,yyline,yycolumn, (yytext())); }

{FOR}              {return new Symbol(sym.FOR,yyline,yycolumn, (yytext())); }
{WHILE}             {return new Symbol(sym.WHILE,yyline,yycolumn, (yytext())); }
{DO}                {return new Symbol(sym.DO,yyline,yycolumn, (yytext())); }
{IF}                {return new Symbol(sym.IF,yyline,yycolumn, (yytext())); }
{ELSE}             {return new Symbol(sym.ELSE,yyline,yycolumn, (yytext())); }
{SWITCH}            {return new Symbol(sym.SWITCH,yyline,yycolumn, (yytext())); }
{CASE}              {return new Symbol(sym.CASE,yyline,yycolumn, (yytext())); }
{BREAK}             {return new Symbol(sym.BREAK,yyline,yycolumn, (yytext())); }
{RETURN}            {return new Symbol(sym.RETURN,yyline,yycolumn, (yytext())); }

{PRIVATE}           {return new Symbol(sym.PRIVATE,yyline,yycolumn, (yytext())); }
{PUBLIC}            {return new Symbol(sym.PUBLIC,yyline,yycolumn, (yytext())); }
{PROTECTED}         {return new Symbol(sym.PROTECTED,yyline,yycolumn, (yytext())); }
{FINAL}             {return new Symbol(sym.FINAL,yyline,yycolumn, (yytext())); }
"static"            {return new Symbol(sym.STATIC,yyline,yycolumn, (yytext())); }
"default"           {return new Symbol(sym.DEFAULT,yyline,yycolumn, (yytext())); }


{COMILLA_SIMPLE}                 {return new Symbol(sym.SIMPLE_COMILLA,yyline,yycolumn, (yytext())); }
{PUNTOCOMA}                 {return new Symbol(sym.PUNTO_COMA,yyline,yycolumn, (yytext())); }
{DOSPUNTOS}                 {return new Symbol(sym.DOBLE_PUNTO,yyline,yycolumn, (yytext())); }
{PUNTO}                 {return new Symbol(sym.PUNTO,yyline,yycolumn, (yytext())); }
{COMA}                 {return new Symbol(sym.COMA,yyline,yycolumn, (yytext())); }

"+="                {return new Symbol(sym.SUMA_IGUAL,yyline,yycolumn, (yytext())); }
"++"                {return new Symbol(sym.CREMENTO,yyline,yycolumn, (yytext())); }
"+"                 {return new Symbol(sym.SUMA,yyline,yycolumn, (yytext())); }
"--"                {return new Symbol(sym.INCREMENTO,yyline,yycolumn, (yytext())); }
"-="                {return new Symbol(sym.RESTA_IGUAL,yyline,yycolumn, (yytext())); }
"-"                 {return new Symbol(sym.RESTA,yyline,yycolumn, (yytext())); }
"*"                 {return new Symbol(sym.MULTIPLICACION,yyline,yycolumn, (yytext())); }
"/"                 {return new Symbol(sym.DIVISION,yyline,yycolumn, (yytext())); }

{OR}{OR}            {return new Symbol(sym.OR,yyline,yycolumn, (yytext())); }
{AND}                {return new Symbol(sym.AND,yyline,yycolumn, (yytext())); }
{IGUALCOMPARACION}   {return new Symbol(sym.DOUBLE_IGUAL,yyline,yycolumn, (yytext())); }
{MENORIGUAL_QUE}       {return new Symbol(sym.MENOR_Q_IGUAL,yyline,yycolumn, (yytext())); }
{MAYORIGUAL_QUE}        {return new Symbol(sym.MAYOR_Q_IGUAL,yyline,yycolumn, (yytext())); }
{MENORQUE}                 {return new Symbol(sym.MENOR_Q,yyline,yycolumn, (yytext())); }
{MAYORQUE}                 {return new Symbol(sym.MAYOR_Q,yyline,yycolumn, (yytext())); }
"&"                 {return new Symbol(sym.ONEY,yyline,yycolumn, (yytext())); }
{OR}                {return new Symbol(sym.ONEO,yyline,yycolumn, (yytext())); }
/*SIMBOLOS OPERADOR*/
"="                 {return new Symbol(sym.IGUAL,yyline,yycolumn, (yytext())); }
{DISTINTOCOMPARACION}                {return new Symbol(sym.ADMIRACION_IGUAL,yyline,yycolumn, (yytext())); }
"!"                 {return new Symbol(sym.ADMIRACION,yyline,yycolumn, (yytext())); }
"?"                 {return new Symbol(sym.INTERO,yyline,yycolumn, (yytext())); }

/*agrupacion*/
{PARENTESISABIERTO}                 {return new Symbol(sym.PARENTESISABIERTO,yyline,yycolumn, (yytext())); }
{PARENTESISCERRADO}                 {return new Symbol(sym.PARENTESISCERRADO,yyline,yycolumn, (yytext())); }
{LLAVESABIERTO}                 {return new Symbol(sym.LLAVESABIERTO,yyline,yycolumn, (yytext())); }
{LLAVESCERRADO}                 {return new Symbol(sym.LLAVESCERRADO,yyline,yycolumn, (yytext())); }
{CORCHETEABIERTO}                 {return new Symbol(sym.CORCHETEABIERTO,yyline,yycolumn, (yytext())); }
{CORCHETECERRADO}                 {return new Symbol(sym.CORCHETECERRADO,yyline,yycolumn, (yytext())); }



{STRINGTEXT}            {return new Symbol(sym.TEXT,yyline,yycolumn, (yytext())); }
{ENTERO}            {return new Symbol(sym.ENTERO,yyline,yycolumn, (yytext())); }
{DECIMAL}           {return new Symbol(sym.DECIMAL,yyline,yycolumn, (yytext())); }
{ID}                {return new Symbol(sym.ID,yyline,yycolumn, (yytext())); }
"/*" ~"*/"          {addComments();}
"//" ~"\n"          {addComments();}
{espacio}           {/*ESPACIOS*/}
/*ERRORres

*/
"'"."'"             {return new Symbol(sym.CARACTER,yyline,yycolumn, (yytext())); }
[^]             { throw new Error(yytext()); }
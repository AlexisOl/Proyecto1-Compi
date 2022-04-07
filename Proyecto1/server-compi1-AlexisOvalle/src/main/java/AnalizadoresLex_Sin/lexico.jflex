
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
LETRASESPECIALES = [á|é|í|ó|ú|ñ|â|ê|î|ô|û|Ã|±]
CARACTER = {LETRASESPECIALES} | [a-zA-Z] | _  
ID = {CARACTER} ({CARACTER} | {ENTERO})*
STRING = "\"" ~"\""
OR = ('\u007c')|('|')|("|")|('\u007c')
ENTERO = [+|-]? ([0]|[1-9][0-9]*)
DECIMAL = {ENTERO}[.]{ENTERO}
espacio =[\n | \r | \t | \f | \b]+
%%


"byte"              {return new Symbol(sym.BYTE,yyline,yycolumn, (yytext())); }
"short"             {return new Symbol(sym.SHORT,yyline,yycolumn, (yytext())); }
"int"               {return new Symbol(sym.INT,yyline,yycolumn, (yytext())); }
"long"              {return new Symbol(sym.LONG,yyline,yycolumn, (yytext())); }
"float"             {return new Symbol(sym.FLOAT,yyline,yycolumn, (yytext())); }
"double"            {return new Symbol(sym.DOUBLE,yyline,yycolumn, (yytext())); }
"char"              {return new Symbol(sym.CHAR,yyline,yycolumn, (yytext())); }
"boolean"           {return new Symbol(sym.BOOLEAN,yyline,yycolumn, (yytext())); }
"String"            {return new Symbol(sym.STRING,yyline,yycolumn, (yytext())); }
"true"              {return new Symbol(sym.TRUE,yyline,yycolumn, (yytext())); }
"false"             {return new Symbol(sym.FALSE,yyline,yycolumn, (yytext())); }
{DECIMAL}"f"        {return new Symbol(sym.F,yyline,yycolumn, (yytext())); }
"/u"{ENTERO}[a-z]?  {return new Symbol(sym.CHARTN,yyline,yycolumn, (yytext())); }
"package"           {return new Symbol(sym.PACKAGE,yyline,yycolumn, (yytext())); }
"import"            {return new Symbol(sym.IMPORT,yyline,yycolumn, (yytext())); }
"class"             {return new Symbol(sym.CLASS,yyline,yycolumn, (yytext())); }
"this"              {return new Symbol(sym.THIS,yyline,yycolumn, (yytext())); }
"extends"           {return new Symbol(sym.EXNTENDS,yyline,yycolumn, (yytext())); }
"implements"        {return new Symbol(sym.IMPLEMENTS,yyline,yycolumn, (yytext())); }
"super"             {return new Symbol(sym.SUPER,yyline,yycolumn, (yytext())); }
"new"               {return new Symbol(sym.NEW,yyline,yycolumn, (yytext())); }
"void"              {return new Symbol(sym.VOID,yyline,yycolumn, (yytext())); }
"try"               {return new Symbol(sym.TRY,yyline,yycolumn, (yytext())); }
"catch"             {return new Symbol(sym.CATCH,yyline,yycolumn, (yytext())); }
"for"               {return new Symbol(sym.FOR,yyline,yycolumn, (yytext())); }
"while"             {return new Symbol(sym.WHILE,yyline,yycolumn, (yytext())); }
"do"                {return new Symbol(sym.DO,yyline,yycolumn, (yytext())); }
"if"                {return new Symbol(sym.IF,yyline,yycolumn, (yytext())); }
"else"              {return new Symbol(sym.ELSE,yyline,yycolumn, (yytext())); }
"switch"            {return new Symbol(sym.SWITCH,yyline,yycolumn, (yytext())); }
"case"              {return new Symbol(sym.CASE,yyline,yycolumn, (yytext())); }

"private"           {return new Symbol(sym.PRIVATE,yyline,yycolumn, (yytext())); }
"public"            {return new Symbol(sym.PUBLIC,yyline,yycolumn, (yytext())); }
"protected"         {return new Symbol(sym.PROTECTED,yyline,yycolumn, (yytext())); }
"final"             {return new Symbol(sym.FINAL,yyline,yycolumn, (yytext())); }
"static"            {return new Symbol(sym.STATIC,yyline,yycolumn, (yytext())); }
"break"             {return new Symbol(sym.BREAK,yyline,yycolumn, (yytext())); }
"default"           {return new Symbol(sym.DEFAULT,yyline,yycolumn, (yytext())); }
"return"            {return new Symbol(sym.RETURN,yyline,yycolumn, (yytext())); }
"'"                 {return new Symbol(sym.SIMPLE_COMILLA,yyline,yycolumn, (yytext())); }
";"                 {return new Symbol(sym.PUNTO_COMA,yyline,yycolumn, (yytext())); }
":"                 {return new Symbol(sym.DOBLE_PUNTO,yyline,yycolumn, (yytext())); }
"."                 {return new Symbol(sym.PUNTO,yyline,yycolumn, (yytext())); }
","                 {return new Symbol(sym.COMA,yyline,yycolumn, (yytext())); }

"+="                {return new Symbol(sym.SUMA_IGUAL,yyline,yycolumn, (yytext())); }
"++"                {return new Symbol(sym.CREMENTO,yyline,yycolumn, (yytext())); }
"+"                 {return new Symbol(sym.SUMA,yyline,yycolumn, (yytext())); }
"--"                {return new Symbol(sym.INCREMENTO,yyline,yycolumn, (yytext())); }
"-="                {return new Symbol(sym.RESTA_IGUAL,yyline,yycolumn, (yytext())); }
"-"                 {return new Symbol(sym.RESTA,yyline,yycolumn, (yytext())); }
"*="                {return new Symbol(sym.MULTIPLICACION_IGUAL,yyline,yycolumn, (yytext())); }
"*"                 {return new Symbol(sym.MULTIPLICACION,yyline,yycolumn, (yytext())); }
"/="                {return new Symbol(sym.DIVISION_IGUAL,yyline,yycolumn, (yytext())); }
"/"                 {return new Symbol(sym.DIVISION,yyline,yycolumn, (yytext())); }
"%="                {return new Symbol(sym.MODULO_IGUAL,yyline,yycolumn, (yytext())); }
"%"                 {return new Symbol(sym.MODULO,yyline,yycolumn, (yytext())); }

{OR}{OR}            {return new Symbol(sym.TWOO,yyline,yycolumn, (yytext())); }
"&&"                {return new Symbol(sym.TWOY,yyline,yycolumn, (yytext())); }
"=="                {return new Symbol(sym.DOUBLE_IGUAL,yyline,yycolumn, (yytext())); }
"<="                {return new Symbol(sym.MENOR_Q_IGUAL,yyline,yycolumn, (yytext())); }
">="                {return new Symbol(sym.MAYOR_Q_IGUAL,yyline,yycolumn, (yytext())); }
"<"                 {return new Symbol(sym.MENOR_Q,yyline,yycolumn, (yytext())); }
">"                 {return new Symbol(sym.MAYOR_Q,yyline,yycolumn, (yytext())); }
"&"                 {return new Symbol(sym.ONEY,yyline,yycolumn, (yytext())); }
{OR}                {return new Symbol(sym.ONEO,yyline,yycolumn, (yytext())); }
/*SIMBOLOS OPERADOR*/
"="                 {return new Symbol(sym.IGUAL,yyline,yycolumn, (yytext())); }
"!="                {return new Symbol(sym.ADMIRACION_IGUAL,yyline,yycolumn, (yytext())); }
"!"                 {return new Symbol(sym.ADMIRACION,yyline,yycolumn, (yytext())); }
"?"                 {return new Symbol(sym.INTERO,yyline,yycolumn, (yytext())); }

/*SIMBOLO DE AGRUPACION*/
"("                 {return new Symbol(sym.P_APERTURA,yyline,yycolumn, (yytext())); }
")"                 {return new Symbol(sym.P_CIERRE,yyline,yycolumn, (yytext())); }
"{"                 {return new Symbol(sym.L_APERTURA,yyline,yycolumn, (yytext())); }
"}"                 {return new Symbol(sym.L_CIERRE,yyline,yycolumn, (yytext())); }
"["                 {return new Symbol(sym.C_APERTURA,yyline,yycolumn, (yytext())); }
"]"                 {return new Symbol(sym.C_CIERRE,yyline,yycolumn, (yytext())); }
{STRING}            {return new Symbol(sym.TEXT,yyline,yycolumn, (yytext())); }
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
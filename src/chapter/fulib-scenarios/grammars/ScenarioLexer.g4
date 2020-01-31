lexer grammar ScenarioLexer;

A:     'a';
AND:   'and';
IS:    'is';
THERE: 'There' | 'there';
WITH:  'with';
// ...

HEADLINE: '#' ~[\n]*? [\n];
FULL_STOP: '.';
// ...

INTEGER: [-]? [0-9]+;
// ...

WORD: [a-zA-Z_][a-zA-Z0-9'_-]*;

WS: [ \t\r\n\u000C]+ -> skip;

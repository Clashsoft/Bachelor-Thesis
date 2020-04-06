parser grammar ScenarioParser;
options { tokenVocab = ScenarioLexer; }

file: header sentence* EOF;
header: HEADLINE;
sentence: thereSentence
        // | ...
        ;

thereSentence: THERE IS A WORD withClause (AND withClause)* FULL_STOP;
withClause: WITH WORD WORD;
// ...

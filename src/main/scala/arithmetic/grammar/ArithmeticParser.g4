parser grammar ArithmeticParser;

options { tokenVocab=ArithmeticLexer; }

expr: NUMBER operation NUMBER;

operation: (ADD | SUB | MUL | DIV);
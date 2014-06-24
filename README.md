Base-Converter
==============

A Java utility to convert between arbitrary numeric bases

Probably the most common use cases are the static methods:

    ArbitraryBaseInteger.formatAs(num, base)
    
and

    ArbitraryBaseInteger.interpret(numBaseN, base)
    
For the instantiated version, numbers are stored internally as longs, to keep things efficient.

The most important restriction is that bases must be integers in the range 2..36, inclusive. This ensures that we don't run out of alphabet.

Base-Converter
==============

A Java utility to convert between arbitrary numeric bases

Probably the most common use cases are the static methods:

    ArbitraryBaseInteger.formatAs(num, base)
    
and

    ArbitraryBaseInteger.interpret(num, base)
    
For the instantiated version, numbers are stored internally as longs, to keep things efficient.

The most important restriction is that bases must be integers in the range 2..36, inclusive. This ensures that we don't run out of alphabet.

Excerpt from output:

    64 base 2: 1000000
    64 base 3: 2101
    64 base 5: 224
    64 base 8: 100
    64 base 10: 64
    64 base 12: 54
    64 base 16: 40
    64 base 20: 34
    64 base 25: 2e
    64 base 30: 24
    64 base 36: 1s

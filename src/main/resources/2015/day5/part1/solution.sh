# part 1
grep -E '(.)\1' input.txt;
grep -E '([aeiou].*){3,}' input.txt
grep -E '(ab|cd|pq|xy)' input.txt

# final solution
grep -v -E '(ab|cd|pq|xy)' input.txt | grep -E '(.)\1' | grep -E '([aeiou].*){3,}'  | wc -l

# part 2

grep -E '(..).(..)\1' input.txt; #
grep -E '(.).\1' input.txt; #


# final solution
grep -E '(..).*\1' input.txt | grep -E '(.).\1' | wc -l

# Blob
An Image is a 2-dimensional grid of Pixels. A pixel either has ink (i.e., you can see it) or does not.
This program uses recursion to compute the border length of a blob of ink in an image.
A blob is one or more pixels that are touching each other (neighbours in the grid). Two pixels at
positions (r1; c1) and (r2; c2) are touching each other if one of the following is satisfied:
• r1 = r2 and c1 = c2 +/- 1
• r1 = r2 +/- 1 and c1 = c2

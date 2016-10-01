# Makefile For OpenGL Assignment 2
# CG200 Assignment
# Last Modified: 18/09/16
# Connor Beardsmore - 15504319

# MAKE VARIABLES
LATEX=*.aux,*.log,*.out,*.bbl,*.blg,*.bcf,*.toc,*.lot,*.lof,*.synctex.gz*,*.run.xml

clean :
	rm -f -R src/*.class
	rm -f -R src/simulator/*/*.class		
	rm -f -R documentation/{$(LATEX)}

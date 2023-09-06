@echo off
REM version of https://gist.github.com/tlberglund/3714970 that will run on Microsoft Windows
:repeat
    cls
    git --no-pager log --graph --pretty=oneline --abbrev-commit --decorate --all %*
    timeout 1 >nul
goto repeat
@echo off
echo I'm at home press 1
echo I'm at company press 2
set /p select=please input you selection: 
if %select% == 1 (goto home) ELSE goto company

:home
C:
cd C:\Program Files\MySQL\MySQL Server 5.6\bin
mysqldump -uroot -p318821wan -B HT>E:\hp-getm\HT-DB\%date:~0,4%%date:~5,2%%date:~8,2%.sql.bak
GOTO:EOF

:company
cd C:\Program Files (x86)\MySQL\MySQL Server 5.1\bin
mysqldump -uroot -p318821wan -B HT>C:\Users\eaton_go_s\Desktop\hp-getm\HT-DB\%date:~0,4%%date:~5,2%%date:~8,2%.sql.bak
echo %~dp0
pause
GOTO:EOF


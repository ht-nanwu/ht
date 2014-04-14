@echo off
echo I'm at home press 1
echo I'm at company press 2
set /p select=please input you selection: 
if %select% == 1 (goto home) ELSE goto company

:home
C:
cd C:\Program Files\MySQL\MySQL Server 5.6\bin
mysqldump -uroot -p318821wan -B HT>%~dp0\backup.sql
GOTO:EOF

:company
C:
cd C:\Program Files (x86)\MySQL\MySQL Server 5.1\bin
mysqldump -uroot -p318821wan -B HT>%~dp0\backup.sql
GOTO:EOF


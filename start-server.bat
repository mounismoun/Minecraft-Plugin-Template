@echo off
setlocal
rem Resolve the project even when launched from Explorer or another directory.
pushd "%~dp0" || exit /b 1
call gradlew.bat --console=plain --no-daemon runServer %*
set "server_exit=%ERRORLEVEL%"
popd
if not "%server_exit%"=="0" pause
exit /b %server_exit%

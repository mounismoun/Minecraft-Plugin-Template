# mc-project1

Paper 26.2 빌드 123용 Kotlin 플러그인 기본 프로젝트입니다. 프로젝트 버전은 `1.0`입니다.

- Kotlin 2.3.21 / Gradle 9.3.0 (Wrapper 포함)
- 컴파일 및 서버 실행: JDK 25
- 메인 클래스: `io.github.mounismoun.plugin.McProject1Plugin`

## Java 설정

컴퓨터별 절대 경로를 프로젝트에 저장하지 않습니다. Gradle Wrapper는 `JAVA_HOME`이 있으면 해당 Java를, 없으면 `PATH`의 `java`를 사용합니다.
각 컴퓨터에 JDK 25를 설치하고 `JAVA_HOME` 또는 `PATH`에 등록하는 것을 권장합니다. `JAVA_HOME`은 `bin`이 아닌 JDK 루트 디렉터리여야 합니다.
잘못된 `JAVA_HOME`이 이미 설정되어 있다면 수정하거나 해제해야 `PATH`가 사용됩니다.

Gradle의 Java Toolchain이 로컬 JDK 25를 찾지 못하면 Foojay resolver로 다운로드합니다. 자동 다운로드를 이용할 때에도 Gradle 자체를 시작할 Java 17 이상은 필요합니다.
최초 실행에는 Gradle, JDK(필요한 경우), Paper 및 라이브러리를 받기 위한 인터넷 연결이 필요합니다.

## IntelliJ IDEA에서 작업

1. **Open**으로 프로젝트 루트 폴더를 열고 Gradle 동기화를 진행합니다.
2. **Project Structure → Project SDK**를 JDK 25로 설정합니다. Gradle이 다운로드한 JDK도 사용할 수 있습니다.
3. **Settings → Build, Execution, Deployment → Build Tools → Gradle**에서 Wrapper 사용, Gradle JVM을 로컬 JDK 또는 `JAVA_HOME`, 빌드·실행을 Gradle로 설정합니다.
4. Gradle 도구 창에서 `build` 또는 `runServer` 작업을 실행합니다.

GUI로 실행한 IDEA는 셸의 `PATH`/`JAVA_HOME` 변경을 바로 반영하지 않을 수 있습니다. 이 경우 IDEA를 다시 실행하거나 Gradle JVM에서 JDK를 선택합니다.
IDE가 Java 17 이상의 다른 버전으로 Gradle을 실행해도 컴파일과 서버에는 Toolchain으로 JDK 25를 사용합니다.
Kotlin 공식 코드 스타일과 `.editorconfig`를 포함했으며 `.idea/`, `*.iml`은 Git에서 제외합니다.

## 빌드

macOS: `./gradlew build` / Windows: `gradlew.bat build`

결과물: `build/libs/mc-project1-1.0.jar`

## 개발 서버 실행

- macOS: `start-server.command`를 더블클릭하거나 터미널에서 `./start-server.command` 실행
- Windows: `start-server.bat`를 더블클릭하거나 터미널에서 `.\start-server.bat` 실행
- IDEA: Gradle의 `runServer` 실행 (플러그인 클래스 자체를 실행하지 않습니다)

실행할 때 플러그인을 빌드하고 Paper 26.2 빌드 123을 다운로드·캐시한 뒤, 최신 플러그인 JAR을 로드합니다.
서버 작업 디렉터리는 프로젝트의 `run/`이며 기본 메모리는 최소 1GB, 최대 2GB입니다. 메모리는 `build.gradle.kts`의 `tasks.runServer`에서 변경합니다.

프로젝트 소유자의 동의에 따라 `com.mojang.eula.agree=true`를 실행 시 적용합니다. 별도로 `eula.txt`를 수정할 필요가 없습니다. [Minecraft EULA](https://www.minecraft.net/eula)
같은 버전의 Minecraft Java Edition에서 `localhost:25565`로 접속합니다. 종료할 때 서버 콘솔에 `stop`을 입력합니다.
코드를 수정한 후 서버를 종료하고 실행 스크립트를 다시 실행하면 새 플러그인이 적용됩니다. 같은 디렉터리에서 서버를 동시에 여러 개 실행하지 마세요.

macOS에서 실행 권한이 없다면 `chmod +x gradlew start-server.command`를 한 번 실행하거나 `sh start-server.command`로 실행할 수 있습니다.

## Git 제외 대상

- `run/`: 월드, 로그, 플러그인 데이터, 서버 설정, EULA, 서버가 생성한 라이브러리 등 전체
- `.gradle/`, `.kotlin/`, `build/`: 프로젝트 캐시와 빌드 결과
- `.idea/`, `*.iml`: 컴퓨터별 IDEA 설정
- JVM 오류 로그와 힙 덤프

다운로드한 Gradle/JDK/Paper 캐시는 Gradle 사용자 홈(기본 `~/.gradle`)에도 저장될 수 있으며 프로젝트 외부이므로 Git에 포함되지 않습니다.
Wrapper JAR과 실행 스크립트는 Git에 포함해야 하며 `.gitattributes`로 OS별 줄바꿈을 고정했습니다.

- [Paper 프로젝트 설정](https://docs.papermc.io/paper/dev/project-setup/)
- [Run Paper](https://github.com/jpenilla/run-task)
- [Gradle Java Toolchains](https://docs.gradle.org/current/userguide/toolchains.html)

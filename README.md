Libraries in dependencies does not exist but demonstrates the problem.

1. Run in root directory:
```bash
export LOG_LEVEL=debug
renovate --platform=local --dry-run=lookup 
```

2. Compare results for root-lib vs meta-build-lib resolution:
```
DEBUG: Looking up com.agabeev:root-lib_3.4 in repository https://repo1.maven.org/maven2/ (repository=local)
DEBUG: Looking up com.agabeev:meta-build-lib in repository https://repo1.maven.org/maven2/ (repository=local)
```

Two issues:
1. For scala 3, we should apply major version only, e.g. com.agabeev:root-lib_3
   
   I've already opened issue: https://github.com/renovatebot/renovate/issues/29087 
2. For libraries defined in meta-build sbt file, located at /project/*.scala, we should append scala version from root build.sbt, so that:
   
   `DEBUG: Looking up com.agabeev:meta-build-lib in repository https://repo1.maven.org/maven2/ (repository=local)`
   
   should be
   
   `DEBUG: Looking up com.agabeev:meta-build-lib_3.4 in repository https://repo1.maven.org/maven2/ (repository=local)`
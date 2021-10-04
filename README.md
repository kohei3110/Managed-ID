# App Service with Managed ID

## Table of Contents


## マネージド ID とは

## Azure リソースのデプロイ

- (To Do) ARM Template 作成
- (To Do) テストツールキットの使用

## Web Apps デプロイ

### デプロイの構成

```
$ mvn com.microsoft.azure:azure-webapp-maven-plugin:2.1.0:config
```

### デプロイ

```
$ mvn package azure-webapp:deploy
```

## ビルドパイプラインの作成

package com.hopson.mvp.data.bean;

import com.google.gson.Gson;

public class AppInfo {


    /**
     * buildKey : 828534d1ece2886b87d8308365871963
     * buildIcon : fa4ee900088007471609ec90f340c3f4
     * buildType : 2
     * buildFileKey : 1ff74fd021e9b2ca1c8082e07496901b.apk
     * buildFileName : 合生活_v5.3.8_pub_release_pgyer_20200624_170933.apk
     * buildFileSize : 54730117
     * buildName : 合生活
     * buildVersion : 5.3.8
     * buildVersionNo : 1038
     * buildBuildVersion : 57
     * buildShortcutUrl : yi6Z
     * buildIdentifier : cn.net.cyberway.hosponlife.main
     * buildPassword : 123456
     * buildDescription :
     * buildUpdateDescription : 正式环境 电商门店审核  意见反馈  多渠道 V5.3.8
     * buildLauncherActivity : com.hilife.view.login.ui.SplashActivity
     * buildScreenshots :
     * buildCreated : 2020-06-24 17:11:03
     * appKey : 0211533f318ac88771a70eac8314a1ac
     * appIsTestFlight : 2
     * isJoin : 2
     * isMerged : 2
     */

    private String buildKey;
    private String buildIcon;
    private String buildType;
    private String buildFileKey;
    private String buildFileName;
    private String buildFileSize;
    private String buildName;
    private String buildVersion;
    private String buildVersionNo;
    private String buildBuildVersion;
    private String buildShortcutUrl;
    private String buildIdentifier;
    private String buildPassword;
    private String buildDescription;
    private String buildUpdateDescription;
    private String buildLauncherActivity;
    private String buildScreenshots;
    private String buildCreated;
    private String appKey;
    private String appIsTestFlight;
    private String isJoin;
    private int isMerged;

    public static AppInfo objectFromData(String str) {

        return new Gson().fromJson(str, AppInfo.class);
    }

    public String getBuildKey() {
        return buildKey;
    }

    public void setBuildKey(String buildKey) {
        this.buildKey = buildKey;
    }

    public String getBuildIcon() {
        return buildIcon;
    }

    public void setBuildIcon(String buildIcon) {
        this.buildIcon = buildIcon;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildFileKey() {
        return buildFileKey;
    }

    public void setBuildFileKey(String buildFileKey) {
        this.buildFileKey = buildFileKey;
    }

    public String getBuildFileName() {
        return buildFileName;
    }

    public void setBuildFileName(String buildFileName) {
        this.buildFileName = buildFileName;
    }

    public String getBuildFileSize() {
        return buildFileSize;
    }

    public void setBuildFileSize(String buildFileSize) {
        this.buildFileSize = buildFileSize;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getBuildVersionNo() {
        return buildVersionNo;
    }

    public void setBuildVersionNo(String buildVersionNo) {
        this.buildVersionNo = buildVersionNo;
    }

    public String getBuildBuildVersion() {
        return buildBuildVersion;
    }

    public void setBuildBuildVersion(String buildBuildVersion) {
        this.buildBuildVersion = buildBuildVersion;
    }

    public String getBuildShortcutUrl() {
        return buildShortcutUrl;
    }

    public void setBuildShortcutUrl(String buildShortcutUrl) {
        this.buildShortcutUrl = buildShortcutUrl;
    }

    public String getBuildIdentifier() {
        return buildIdentifier;
    }

    public void setBuildIdentifier(String buildIdentifier) {
        this.buildIdentifier = buildIdentifier;
    }

    public String getBuildPassword() {
        return buildPassword;
    }

    public void setBuildPassword(String buildPassword) {
        this.buildPassword = buildPassword;
    }

    public String getBuildDescription() {
        return buildDescription;
    }

    public void setBuildDescription(String buildDescription) {
        this.buildDescription = buildDescription;
    }

    public String getBuildUpdateDescription() {
        return buildUpdateDescription;
    }

    public void setBuildUpdateDescription(String buildUpdateDescription) {
        this.buildUpdateDescription = buildUpdateDescription;
    }

    public String getBuildLauncherActivity() {
        return buildLauncherActivity;
    }

    public void setBuildLauncherActivity(String buildLauncherActivity) {
        this.buildLauncherActivity = buildLauncherActivity;
    }

    public String getBuildScreenshots() {
        return buildScreenshots;
    }

    public void setBuildScreenshots(String buildScreenshots) {
        this.buildScreenshots = buildScreenshots;
    }

    public String getBuildCreated() {
        return buildCreated;
    }

    public void setBuildCreated(String buildCreated) {
        this.buildCreated = buildCreated;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppIsTestFlight() {
        return appIsTestFlight;
    }

    public void setAppIsTestFlight(String appIsTestFlight) {
        this.appIsTestFlight = appIsTestFlight;
    }

    public String getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(String isJoin) {
        this.isJoin = isJoin;
    }

    public int getIsMerged() {
        return isMerged;
    }

    public void setIsMerged(int isMerged) {
        this.isMerged = isMerged;
    }
}

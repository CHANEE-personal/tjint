package com.tjint.springboot.common;

<<<<<<< HEAD
public class BaseTableInfoVo extends CommonVo {
=======
public class BaseTableInfoVo extends CommonVo{
>>>>>>> 2c3c25514ba256b1dc7fa5b8189d596dede1b3f8
    private static final long serialVersionUID = 1L;
    private String visible;
    private Integer creator;
    private String creatorNm;
    private String createTime;
    private Integer updater;
    private String updaterNm;
    private String updateTime;

    public String getVisible() {
        return this.visible;
    }

    public Integer getCreator() {
        return this.creator;
    }

    public String getCreatorNm() {
        return this.creatorNm;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public Integer getUpdater() {
        return this.updater;
    }

    public String getUpdaterNm() {
        return this.updaterNm;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setVisible(final String visible) {
        this.visible = visible;
    }

    public void setCreator(final Integer creator) {
        this.creator = creator;
    }

    public void setCreatorNm(final String creatorNm) {
        this.creatorNm = creatorNm;
    }

    public void setCreateTime(final String createTime) {
        this.createTime = createTime;
    }

    public void setUpdater(final Integer updater) {
        this.updater = updater;
    }

    public void setUpdaterNm(final String updaterNm) {
        this.updaterNm = updaterNm;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseTableInfoVo)) {
            return false;
        }
        final BaseTableInfoVo other = (BaseTableInfoVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$visible = this.getVisible();
        final Object other$visible = other.getVisible();
        Label_0065: {
            if (this$visible == null) {
                if (other$visible == null) {
                    break Label_0065;
                }
            }
            else if (this$visible.equals(other$visible)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$creator = this.getCreator();
        final Object other$creator = other.getCreator();
        Label_0102: {
            if (this$creator == null) {
                if (other$creator == null) {
                    break Label_0102;
                }
            }
            else if (this$creator.equals(other$creator)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$creatorNm = this.getCreatorNm();
        final Object other$creatorNm = other.getCreatorNm();
        Label_0139: {
            if (this$creatorNm == null) {
                if (other$creatorNm == null) {
                    break Label_0139;
                }
            }
            else if (this$creatorNm.equals(other$creatorNm)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        Label_0176: {
            if (this$createTime == null) {
                if (other$createTime == null) {
                    break Label_0176;
                }
            }
            else if (this$createTime.equals(other$createTime)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$updater = this.getUpdater();
        final Object other$updater = other.getUpdater();
        Label_0213: {
            if (this$updater == null) {
                if (other$updater == null) {
                    break Label_0213;
                }
            }
            else if (this$updater.equals(other$updater)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$updaterNm = this.getUpdaterNm();
        final Object other$updaterNm = other.getUpdaterNm();
        Label_0250: {
            if (this$updaterNm == null) {
                if (other$updaterNm == null) {
                    break Label_0250;
                }
            }
            else if (this$updaterNm.equals(other$updaterNm)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$updateTime = this.getUpdateTime();
        final Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null) {
            if (other$updateTime == null) {
                return true;
            }
        }
        else if (this$updateTime.equals(other$updateTime)) {
            return true;
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseTableInfoVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $visible = this.getVisible();
        result = result * 59 + (($visible == null) ? 43 : $visible.hashCode());
        final Object $creator = this.getCreator();
        result = result * 59 + (($creator == null) ? 43 : $creator.hashCode());
        final Object $creatorNm = this.getCreatorNm();
        result = result * 59 + (($creatorNm == null) ? 43 : $creatorNm.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * 59 + (($createTime == null) ? 43 : $createTime.hashCode());
        final Object $updater = this.getUpdater();
        result = result * 59 + (($updater == null) ? 43 : $updater.hashCode());
        final Object $updaterNm = this.getUpdaterNm();
        result = result * 59 + (($updaterNm == null) ? 43 : $updaterNm.hashCode());
        final Object $updateTime = this.getUpdateTime();
        result = result * 59 + (($updateTime == null) ? 43 : $updateTime.hashCode());
        return result;
    }

    public String toString() {
        return "BaseTableInfoVO(visible=" + this.getVisible() + ", creator=" + this.getCreator() + ", creatorNm=" + this.getCreatorNm() + ", createTime=" + this.getCreateTime() + ", updater=" + this.getUpdater() + ", updaterNm=" + this.getUpdaterNm() + ", updateTime=" + this.getUpdateTime() + ")";
    }
}

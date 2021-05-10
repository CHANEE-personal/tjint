package com.tjint.springboot.common;

public class MetaVo {
    private String title;
    private String description;
    private String image;
    private String url;

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public String getUrl() {
        return this.url;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MetaVo)) {
            return false;
        }
        final MetaVo other = (MetaVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        Label_0065: {
            if (this$title == null) {
                if (other$title == null) {
                    break Label_0065;
                }
            }
            else if (this$title.equals(other$title)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        Label_0102: {
            if (this$description == null) {
                if (other$description == null) {
                    break Label_0102;
                }
            }
            else if (this$description.equals(other$description)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        Label_0139: {
            if (this$image == null) {
                if (other$image == null) {
                    break Label_0139;
                }
            }
            else if (this$image.equals(other$image)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null) {
            if (other$url == null) {
                return true;
            }
        }
        else if (this$url.equals(other$url)) {
            return true;
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MetaVo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * 59 + (($title == null) ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * 59 + (($description == null) ? 43 : $description.hashCode());
        final Object $image = this.getImage();
        result = result * 59 + (($image == null) ? 43 : $image.hashCode());
        final Object $url = this.getUrl();
        result = result * 59 + (($url == null) ? 43 : $url.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetaVo(title=" + this.getTitle() + ", description=" + this.getDescription() + ", image=" + this.getImage() + ", url=" + this.getUrl() + ")";
    }
}

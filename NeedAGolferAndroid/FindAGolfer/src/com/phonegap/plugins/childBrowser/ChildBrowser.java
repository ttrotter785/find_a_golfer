


<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# githubog: http://ogp.me/ns/fb/githubog#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java at master from phonegap/phonegap-plugins - GitHub</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />

    
    

    <meta content="authenticity_token" name="csrf-param" />
<meta content="WqB+mVtyVbarBGvFur3gWLyxUwdV6BkV6vhATuR9Y3o=" name="csrf-token" />

    <link href="https://a248.e.akamai.net/assets.github.com/stylesheets/bundles/github-c2f83c57a14d5e54d816673f52563d987fe2821f.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="https://a248.e.akamai.net/assets.github.com/stylesheets/bundles/github2-c9900fb44a3c616c729002fdd694ae1359b848f5.css" media="screen" rel="stylesheet" type="text/css" />
    

    <script src="https://a248.e.akamai.net/assets.github.com/javascripts/bundles/jquery-5b140862bd914d3619171dece9be92269c2b1fe1.js" type="text/javascript"></script>
    <script src="https://a248.e.akamai.net/assets.github.com/javascripts/bundles/github-24d080082f56c23229d24ca8cdc0d3d5c9cd505d.js" type="text/javascript"></script>
    

      <link rel='permalink' href='/phonegap/phonegap-plugins/blob/2dc6525b2c96f7231d07bb913e6120838bd9caad/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java'>
    <meta property="og:title" content="phonegap-plugins"/>
    <meta property="og:type" content="githubog:gitrepository"/>
    <meta property="og:url" content="https://github.com/phonegap/phonegap-plugins"/>
    <meta property="og:image" content="https://a248.e.akamai.net/assets.github.com/images/gravatars/gravatar-140.png?1329275985"/>
    <meta property="og:site_name" content="GitHub"/>
    <meta property="og:description" content="phonegap-plugins - Plugins for use with PhoneGap. "/>

    <meta name="description" content="phonegap-plugins - Plugins for use with PhoneGap. " />
  <link href="https://github.com/phonegap/phonegap-plugins/commits/master.atom" rel="alternate" title="Recent Commits to phonegap-plugins:master" type="application/atom+xml" />

  </head>


  <body class="logged_out page-blob windows vis-public fork env-production " data-blob-contribs-enabled="yes">
    


    

      <div id="header" class="true clearfix">
        <div class="container clearfix">
          <a class="site-logo" href="https://github.com">
            <!--[if IE]>
            <img alt="GitHub" class="github-logo" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov7.png?1323882804" />
            <img alt="GitHub" class="github-logo-hover" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov7-hover.png?1324325453" />
            <![endif]-->
            <img alt="GitHub" class="github-logo-4x" height="30" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov7@4x.png?1323882804" />
            <img alt="GitHub" class="github-logo-4x-hover" height="30" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov7@4x-hover.png?1324325453" />
          </a>

                  <!--
      make sure to use fully qualified URLs here since this nav
      is used on error pages on other domains
    -->
    <ul class="top-nav logged_out">
        <li class="pricing"><a href="https://github.com/plans">Signup and Pricing</a></li>
        <li class="explore"><a href="https://github.com/explore">Explore GitHub</a></li>
      <li class="features"><a href="https://github.com/features">Features</a></li>
        <li class="blog"><a href="https://github.com/blog">Blog</a></li>
      <li class="login"><a href="https://github.com/login?return_to=%2Fphonegap%2Fphonegap-plugins%2Fblob%2Fmaster%2FAndroid%2FChildBrowser%2Fsrc%2Fcom%2Fphonegap%2Fplugins%2FchildBrowser%2FChildBrowser.java">Login</a></li>
    </ul>



          
        </div>
      </div>

      

            <div class="site">
      <div class="container">
        <div class="pagehead repohead instapaper_ignore readability-menu">
        <div class="title-actions-bar">
          <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
<a href="/phonegap" itemprop="url">            <span itemprop="title">phonegap</span>
            </a> /
            <strong><a href="/phonegap/phonegap-plugins" class="js-current-repository">phonegap-plugins</a></strong>
              <span class="fork-flag">
                <span class="text">forked from <a href="/purplecabbage/phonegap-plugins">purplecabbage/phonegap-plugins</a></span>
              </span>
          </h1>
          



              <ul class="pagehead-actions">


          <li><a href="/login?return_to=%2Fphonegap%2Fphonegap-plugins" class="minibutton btn-watch watch-button entice tooltipped leftwards" rel="nofollow" title="You must be logged in to use this feature"><span><span class="icon"></span>Watch</span></a></li>
          <li><a href="/login?return_to=%2Fphonegap%2Fphonegap-plugins" class="minibutton btn-fork fork-button entice tooltipped leftwards" rel="nofollow" title="You must be logged in to use this feature"><span><span class="icon"></span>Fork</span></a></li>


      <li class="repostats">
        <ul class="repo-stats">
          <li class="watchers ">
            <a href="/phonegap/phonegap-plugins/watchers" title="Watchers" class="tooltipped downwards">
              951
            </a>
          </li>
          <li class="forks">
            <a href="/phonegap/phonegap-plugins/network" title="Forks" class="tooltipped downwards">
              320
            </a>
          </li>
        </ul>
      </li>
    </ul>

        </div>

          

  <ul class="tabs">
    <li><a href="/phonegap/phonegap-plugins" class="selected" highlight="repo_sourcerepo_downloadsrepo_commitsrepo_tagsrepo_branches">Code</a></li>
    <li><a href="/phonegap/phonegap-plugins/network" highlight="repo_networkrepo_fork_queue">Network</a>
    <li><a href="/phonegap/phonegap-plugins/pulls" highlight="repo_pulls">Pull Requests <span class='counter'>25</span></a></li>

      <li><a href="/phonegap/phonegap-plugins/issues" highlight="repo_issues">Issues <span class='counter'>90</span></a></li>


    <li><a href="/phonegap/phonegap-plugins/graphs" highlight="repo_graphsrepo_contributors">Stats &amp; Graphs</a></li>

  </ul>

  
<div class="frame frame-center tree-finder" style="display:none"
      data-tree-list-url="/phonegap/phonegap-plugins/tree-list/2dc6525b2c96f7231d07bb913e6120838bd9caad"
      data-blob-url-prefix="/phonegap/phonegap-plugins/blob/2dc6525b2c96f7231d07bb913e6120838bd9caad"
    >

  <div class="breadcrumb">
    <span class="bold"><a href="/phonegap/phonegap-plugins">phonegap-plugins</a></span> /
    <input class="tree-finder-input js-navigation-enable" type="text" name="query" autocomplete="off" spellcheck="false">
  </div>

    <div class="octotip">
      <p>
        <a href="/phonegap/phonegap-plugins/dismiss-tree-finder-help" class="dismiss js-dismiss-tree-list-help" title="Hide this notice forever" rel="nofollow">Dismiss</a>
        <span class="bold">Octotip:</span> You've activated the <em>file finder</em>
        by pressing <span class="kbd">t</span> Start typing to filter the
        file list. Use <span class="kbd badmono">↑</span> and
        <span class="kbd badmono">↓</span> to navigate,
        <span class="kbd">enter</span> to view files.
      </p>
    </div>

  <table class="tree-browser" cellpadding="0" cellspacing="0">
    <tr class="js-header"><th>&nbsp;</th><th>name</th></tr>
    <tr class="js-no-results no-results" style="display: none">
      <th colspan="2">No matching files</th>
    </tr>
    <tbody class="js-results-list js-navigation-container">
    </tbody>
  </table>
</div>

<div id="jump-to-line" style="display:none">
  <h2>Jump to Line</h2>
  <form>
    <input class="textfield" type="text">
    <div class="full-button">
      <button type="submit" class="classy">
        <span>Go</span>
      </button>
    </div>
  </form>
</div>


<div class="subnav-bar">

  <ul class="actions subnav">
    <li><a href="/phonegap/phonegap-plugins/tags" class="" highlight="repo_tags">Tags <span class="counter">1</span></a></li>
    <li><a href="/phonegap/phonegap-plugins/downloads" class="blank downloads-blank" highlight="repo_downloads">Downloads <span class="counter">0</span></a></li>
    
  </ul>

  <ul class="scope">
    <li class="switcher">

      <div class="context-menu-container js-menu-container">
        <a href="#"
           class="minibutton bigger switcher js-menu-target js-commitish-button btn-branch repo-tree"
           data-master-branch="master"
           data-ref="master">
          <span><span class="icon"></span><i>branch:</i> master</span>
        </a>

        <div class="context-pane commitish-context js-menu-content">
          <a href="javascript:;" class="close js-menu-close"></a>
          <div class="context-title">Switch Branches/Tags</div>
          <div class="context-body pane-selector commitish-selector js-filterable-commitishes">
            <div class="filterbar">
              <div class="placeholder-field js-placeholder-field">
                <label class="placeholder" for="context-commitish-filter-field" data-placeholder-mode="sticky">Filter branches/tags</label>
                <input type="text" id="context-commitish-filter-field" class="commitish-filter" />
              </div>

              <ul class="tabs">
                <li><a href="#" data-filter="branches" class="selected">Branches</a></li>
                <li><a href="#" data-filter="tags">Tags</a></li>
              </ul>
            </div>

              <div class="commitish-item branch-commitish selector-item">
                <h4>
                    <a href="/phonegap/phonegap-plugins/blob/master/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" data-name="master" rel="nofollow">master</a>
                </h4>
              </div>

              <div class="commitish-item tag-commitish selector-item">
                <h4>
                    <a href="/phonegap/phonegap-plugins/blob/AdPlugin-20100712/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" data-name="AdPlugin-20100712" rel="nofollow">AdPlugin-20100712</a>
                </h4>
              </div>

            <div class="no-results" style="display:none">Nothing to show</div>
          </div>
        </div><!-- /.commitish-context-context -->
      </div>

    </li>
  </ul>

  <ul class="subnav with-scope">

    <li><a href="/phonegap/phonegap-plugins" class="selected" highlight="repo_source">Files</a></li>
    <li><a href="/phonegap/phonegap-plugins/commits/master" highlight="repo_commits">Commits</a></li>
    <li><a href="/phonegap/phonegap-plugins/branches" class="" highlight="repo_branches" rel="nofollow">Branches <span class="counter">1</span></a></li>
  </ul>

</div>

  
  
  


          

        </div><!-- /.repohead -->

        





<!-- block_view_fragment_key: views4/v8/blob:v17:19ee7f4594ddf0f6b2eafe2d635badbe -->
  <div id="slider">

    <div class="breadcrumb" data-path="Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java/">
      <b itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f" class="js-rewrite-sha" itemprop="url"><span itemprop="title">phonegap-plugins</span></a></b> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android" class="js-rewrite-sha" itemscope="url"><span itemprop="title">Android</span></a></span> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser" class="js-rewrite-sha" itemscope="url"><span itemprop="title">ChildBrowser</span></a></span> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src" class="js-rewrite-sha" itemscope="url"><span itemprop="title">src</span></a></span> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src/com" class="js-rewrite-sha" itemscope="url"><span itemprop="title">com</span></a></span> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src/com/phonegap" class="js-rewrite-sha" itemscope="url"><span itemprop="title">phonegap</span></a></span> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src/com/phonegap/plugins" class="js-rewrite-sha" itemscope="url"><span itemprop="title">plugins</span></a></span> / <span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/phonegap/phonegap-plugins/tree/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser" class="js-rewrite-sha" itemscope="url"><span itemprop="title">childBrowser</span></a></span> / <strong class="final-path">ChildBrowser.java</strong> <span class="js-clippy clippy-button " data-clipboard-text="Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" data-copied-hint="copied!" data-copy-hint="copy to clipboard"></span>
    </div>


      <div class="commit file-history-tease" data-path="Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java/">
        <img class="main-avatar" height="24" src="https://secure.gravatar.com/avatar/3912c4beca80e2d9ae973af181556704?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" width="24" />
        <span class="author"><a href="/kwellman">kwellman</a></span>
        <time class="js-relative-date" datetime="2011-12-10T20:57:30-08:00" title="2011-12-10 20:57:30">December 10, 2011</time>
        <div class="commit-title">
            <a href="/phonegap/phonegap-plugins/commit/e62518fd583132e7f3572a5a26a9eeee58d022d7" class="message">stop web view loading when child browser dialog is closed</a>
        </div>

        <div class="participation">
          <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>2</strong> contributors</a></p>
              <a class="avatar tooltipped downwards" title="macdonst" href="/phonegap/phonegap-plugins/commits/master/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java?author=macdonst"><img height="20" src="https://secure.gravatar.com/avatar/b8dadcd56f71bf5e126bd937601f03fd?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" width="20" /><span class="overlay size-20"></span></a>
    <a class="avatar tooltipped downwards" title="kwellman" href="/phonegap/phonegap-plugins/commits/master/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java?author=kwellman"><img height="20" src="https://secure.gravatar.com/avatar/3912c4beca80e2d9ae973af181556704?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" width="20" /><span class="overlay size-20"></span></a>


        </div>
        <div id="blob_contributors_box" style="display:none">
          <h2>Users on GitHub who have contributed to this file</h2>
          <ul class="facebox-user-list">
            <li>
              <img height="24" src="https://secure.gravatar.com/avatar/b8dadcd56f71bf5e126bd937601f03fd?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" width="24" />
              <a href="/macdonst">macdonst</a>
            </li>
            <li>
              <img height="24" src="https://secure.gravatar.com/avatar/3912c4beca80e2d9ae973af181556704?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" width="24" />
              <a href="/kwellman">kwellman</a>
            </li>
          </ul>
        </div>
      </div>

    <div class="frames">
      <div class="frame frame-center" data-path="Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java/" data-permalink-url="/phonegap/phonegap-plugins/blob/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" data-title="Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java at master from phonegap/phonegap-plugins - GitHub" data-type="blob">

        <div id="files" class="bubble">
          <div class="file">
            <div class="meta">
              <div class="info">
                <span class="icon"><img alt="Txt" height="16" src="https://a248.e.akamai.net/assets.github.com/images/icons/txt.png?1315928456" width="16" /></span>
                <span class="mode" title="File Mode">100644</span>
                  <span>406 lines (355 sloc)</span>
                <span>15.444 kb</span>
              </div>
              <ul class="button-group actions">
                  <li>
                    <a class="grouped-button file-edit-link minibutton bigger lighter js-rewrite-sha" href="/phonegap/phonegap-plugins/edit/eb02b16497f49481679424f3efb6705ff37c9b4f/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" data-method="post" rel="nofollow"><span>Edit this file</span></a>
                  </li>

                <li>
                  <a href="/phonegap/phonegap-plugins/raw/master/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" class="minibutton btn-raw grouped-button bigger lighter" id="raw-url"><span><span class="icon"></span>Raw</span></a>
                </li>
                  <li>
                    <a href="/phonegap/phonegap-plugins/blame/master/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" class="minibutton btn-blame grouped-button bigger lighter"><span><span class="icon"></span>Blame</span></a>
                  </li>
                <li>
                  <a href="/phonegap/phonegap-plugins/commits/master/Android/ChildBrowser/src/com/phonegap/plugins/childBrowser/ChildBrowser.java" class="minibutton btn-history grouped-button bigger lighter" rel="nofollow"><span><span class="icon"></span>History</span></a>
                </li>
              </ul>
            </div>
              <div class="data type-java">
      <table cellpadding="0" cellspacing="0" class="lines">
        <tr>
          <td>
            <pre class="line_numbers"><span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>
<span id="L268" rel="#L268">268</span>
<span id="L269" rel="#L269">269</span>
<span id="L270" rel="#L270">270</span>
<span id="L271" rel="#L271">271</span>
<span id="L272" rel="#L272">272</span>
<span id="L273" rel="#L273">273</span>
<span id="L274" rel="#L274">274</span>
<span id="L275" rel="#L275">275</span>
<span id="L276" rel="#L276">276</span>
<span id="L277" rel="#L277">277</span>
<span id="L278" rel="#L278">278</span>
<span id="L279" rel="#L279">279</span>
<span id="L280" rel="#L280">280</span>
<span id="L281" rel="#L281">281</span>
<span id="L282" rel="#L282">282</span>
<span id="L283" rel="#L283">283</span>
<span id="L284" rel="#L284">284</span>
<span id="L285" rel="#L285">285</span>
<span id="L286" rel="#L286">286</span>
<span id="L287" rel="#L287">287</span>
<span id="L288" rel="#L288">288</span>
<span id="L289" rel="#L289">289</span>
<span id="L290" rel="#L290">290</span>
<span id="L291" rel="#L291">291</span>
<span id="L292" rel="#L292">292</span>
<span id="L293" rel="#L293">293</span>
<span id="L294" rel="#L294">294</span>
<span id="L295" rel="#L295">295</span>
<span id="L296" rel="#L296">296</span>
<span id="L297" rel="#L297">297</span>
<span id="L298" rel="#L298">298</span>
<span id="L299" rel="#L299">299</span>
<span id="L300" rel="#L300">300</span>
<span id="L301" rel="#L301">301</span>
<span id="L302" rel="#L302">302</span>
<span id="L303" rel="#L303">303</span>
<span id="L304" rel="#L304">304</span>
<span id="L305" rel="#L305">305</span>
<span id="L306" rel="#L306">306</span>
<span id="L307" rel="#L307">307</span>
<span id="L308" rel="#L308">308</span>
<span id="L309" rel="#L309">309</span>
<span id="L310" rel="#L310">310</span>
<span id="L311" rel="#L311">311</span>
<span id="L312" rel="#L312">312</span>
<span id="L313" rel="#L313">313</span>
<span id="L314" rel="#L314">314</span>
<span id="L315" rel="#L315">315</span>
<span id="L316" rel="#L316">316</span>
<span id="L317" rel="#L317">317</span>
<span id="L318" rel="#L318">318</span>
<span id="L319" rel="#L319">319</span>
<span id="L320" rel="#L320">320</span>
<span id="L321" rel="#L321">321</span>
<span id="L322" rel="#L322">322</span>
<span id="L323" rel="#L323">323</span>
<span id="L324" rel="#L324">324</span>
<span id="L325" rel="#L325">325</span>
<span id="L326" rel="#L326">326</span>
<span id="L327" rel="#L327">327</span>
<span id="L328" rel="#L328">328</span>
<span id="L329" rel="#L329">329</span>
<span id="L330" rel="#L330">330</span>
<span id="L331" rel="#L331">331</span>
<span id="L332" rel="#L332">332</span>
<span id="L333" rel="#L333">333</span>
<span id="L334" rel="#L334">334</span>
<span id="L335" rel="#L335">335</span>
<span id="L336" rel="#L336">336</span>
<span id="L337" rel="#L337">337</span>
<span id="L338" rel="#L338">338</span>
<span id="L339" rel="#L339">339</span>
<span id="L340" rel="#L340">340</span>
<span id="L341" rel="#L341">341</span>
<span id="L342" rel="#L342">342</span>
<span id="L343" rel="#L343">343</span>
<span id="L344" rel="#L344">344</span>
<span id="L345" rel="#L345">345</span>
<span id="L346" rel="#L346">346</span>
<span id="L347" rel="#L347">347</span>
<span id="L348" rel="#L348">348</span>
<span id="L349" rel="#L349">349</span>
<span id="L350" rel="#L350">350</span>
<span id="L351" rel="#L351">351</span>
<span id="L352" rel="#L352">352</span>
<span id="L353" rel="#L353">353</span>
<span id="L354" rel="#L354">354</span>
<span id="L355" rel="#L355">355</span>
<span id="L356" rel="#L356">356</span>
<span id="L357" rel="#L357">357</span>
<span id="L358" rel="#L358">358</span>
<span id="L359" rel="#L359">359</span>
<span id="L360" rel="#L360">360</span>
<span id="L361" rel="#L361">361</span>
<span id="L362" rel="#L362">362</span>
<span id="L363" rel="#L363">363</span>
<span id="L364" rel="#L364">364</span>
<span id="L365" rel="#L365">365</span>
<span id="L366" rel="#L366">366</span>
<span id="L367" rel="#L367">367</span>
<span id="L368" rel="#L368">368</span>
<span id="L369" rel="#L369">369</span>
<span id="L370" rel="#L370">370</span>
<span id="L371" rel="#L371">371</span>
<span id="L372" rel="#L372">372</span>
<span id="L373" rel="#L373">373</span>
<span id="L374" rel="#L374">374</span>
<span id="L375" rel="#L375">375</span>
<span id="L376" rel="#L376">376</span>
<span id="L377" rel="#L377">377</span>
<span id="L378" rel="#L378">378</span>
<span id="L379" rel="#L379">379</span>
<span id="L380" rel="#L380">380</span>
<span id="L381" rel="#L381">381</span>
<span id="L382" rel="#L382">382</span>
<span id="L383" rel="#L383">383</span>
<span id="L384" rel="#L384">384</span>
<span id="L385" rel="#L385">385</span>
<span id="L386" rel="#L386">386</span>
<span id="L387" rel="#L387">387</span>
<span id="L388" rel="#L388">388</span>
<span id="L389" rel="#L389">389</span>
<span id="L390" rel="#L390">390</span>
<span id="L391" rel="#L391">391</span>
<span id="L392" rel="#L392">392</span>
<span id="L393" rel="#L393">393</span>
<span id="L394" rel="#L394">394</span>
<span id="L395" rel="#L395">395</span>
<span id="L396" rel="#L396">396</span>
<span id="L397" rel="#L397">397</span>
<span id="L398" rel="#L398">398</span>
<span id="L399" rel="#L399">399</span>
<span id="L400" rel="#L400">400</span>
<span id="L401" rel="#L401">401</span>
<span id="L402" rel="#L402">402</span>
<span id="L403" rel="#L403">403</span>
<span id="L404" rel="#L404">404</span>
<span id="L405" rel="#L405">405</span>
</pre>
          </td>
          <td width="100%">
                <div class="highlight"><pre><div class='line' id='LC1'><span class="cm">/*</span></div><div class='line' id='LC2'><span class="cm"> * PhoneGap is available under *either* the terms of the modified BSD license *or* the</span></div><div class='line' id='LC3'><span class="cm"> * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.</span></div><div class='line' id='LC4'><span class="cm"> *</span></div><div class='line' id='LC5'><span class="cm"> * Copyright (c) 2005-2011, Nitobi Software Inc.</span></div><div class='line' id='LC6'><span class="cm"> * Copyright (c) 2010-2011, IBM Corporation</span></div><div class='line' id='LC7'><span class="cm"> */</span></div><div class='line' id='LC8'><span class="kn">package</span> <span class="n">com</span><span class="o">.</span><span class="na">phonegap</span><span class="o">.</span><span class="na">plugins</span><span class="o">.</span><span class="na">childBrowser</span><span class="o">;</span></div><div class='line' id='LC9'><br/></div><div class='line' id='LC10'><span class="kn">import</span> <span class="nn">java.io.IOException</span><span class="o">;</span></div><div class='line' id='LC11'><span class="kn">import</span> <span class="nn">java.io.InputStream</span><span class="o">;</span></div><div class='line' id='LC12'><br/></div><div class='line' id='LC13'><span class="kn">import</span> <span class="nn">org.json.JSONArray</span><span class="o">;</span></div><div class='line' id='LC14'><span class="kn">import</span> <span class="nn">org.json.JSONException</span><span class="o">;</span></div><div class='line' id='LC15'><span class="kn">import</span> <span class="nn">org.json.JSONObject</span><span class="o">;</span></div><div class='line' id='LC16'><br/></div><div class='line' id='LC17'><span class="kn">import</span> <span class="nn">android.app.Dialog</span><span class="o">;</span></div><div class='line' id='LC18'><span class="kn">import</span> <span class="nn">android.content.Context</span><span class="o">;</span></div><div class='line' id='LC19'><span class="kn">import</span> <span class="nn">android.content.DialogInterface</span><span class="o">;</span></div><div class='line' id='LC20'><span class="kn">import</span> <span class="nn">android.content.Intent</span><span class="o">;</span></div><div class='line' id='LC21'><span class="kn">import</span> <span class="nn">android.graphics.Bitmap</span><span class="o">;</span></div><div class='line' id='LC22'><span class="kn">import</span> <span class="nn">android.graphics.BitmapFactory</span><span class="o">;</span></div><div class='line' id='LC23'><span class="kn">import</span> <span class="nn">android.net.Uri</span><span class="o">;</span></div><div class='line' id='LC24'><span class="kn">import</span> <span class="nn">android.util.Log</span><span class="o">;</span></div><div class='line' id='LC25'><span class="kn">import</span> <span class="nn">android.view.KeyEvent</span><span class="o">;</span></div><div class='line' id='LC26'><span class="kn">import</span> <span class="nn">android.view.View</span><span class="o">;</span></div><div class='line' id='LC27'><span class="kn">import</span> <span class="nn">android.view.Window</span><span class="o">;</span></div><div class='line' id='LC28'><span class="kn">import</span> <span class="nn">android.view.WindowManager</span><span class="o">;</span></div><div class='line' id='LC29'><span class="kn">import</span> <span class="nn">android.view.WindowManager.LayoutParams</span><span class="o">;</span></div><div class='line' id='LC30'><span class="kn">import</span> <span class="nn">android.view.inputmethod.InputMethodManager</span><span class="o">;</span></div><div class='line' id='LC31'><span class="kn">import</span> <span class="nn">android.webkit.WebView</span><span class="o">;</span></div><div class='line' id='LC32'><span class="kn">import</span> <span class="nn">android.webkit.WebViewClient</span><span class="o">;</span></div><div class='line' id='LC33'><span class="kn">import</span> <span class="nn">android.widget.EditText</span><span class="o">;</span></div><div class='line' id='LC34'><span class="kn">import</span> <span class="nn">android.widget.ImageButton</span><span class="o">;</span></div><div class='line' id='LC35'><span class="kn">import</span> <span class="nn">android.widget.LinearLayout</span><span class="o">;</span></div><div class='line' id='LC36'><br/></div><div class='line' id='LC37'><span class="kn">import</span> <span class="nn">com.phonegap.api.PhonegapActivity</span><span class="o">;</span></div><div class='line' id='LC38'><span class="kn">import</span> <span class="nn">com.phonegap.api.Plugin</span><span class="o">;</span></div><div class='line' id='LC39'><span class="kn">import</span> <span class="nn">com.phonegap.api.PluginResult</span><span class="o">;</span></div><div class='line' id='LC40'><br/></div><div class='line' id='LC41'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">ChildBrowser</span> <span class="kd">extends</span> <span class="n">Plugin</span> <span class="o">{</span></div><div class='line' id='LC42'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC43'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">protected</span> <span class="kd">static</span> <span class="kd">final</span> <span class="n">String</span> <span class="n">LOG_TAG</span> <span class="o">=</span> <span class="s">&quot;ChildBrowser&quot;</span><span class="o">;</span></div><div class='line' id='LC44'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kd">static</span> <span class="kt">int</span> <span class="n">CLOSE_EVENT</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></div><div class='line' id='LC45'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kd">static</span> <span class="kt">int</span> <span class="n">LOCATION_CHANGED_EVENT</span> <span class="o">=</span> <span class="mi">1</span><span class="o">;</span></div><div class='line' id='LC46'><br/></div><div class='line' id='LC47'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">String</span> <span class="n">browserCallbackId</span> <span class="o">=</span> <span class="kc">null</span><span class="o">;</span></div><div class='line' id='LC48'><br/></div><div class='line' id='LC49'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">Dialog</span> <span class="n">dialog</span><span class="o">;</span></div><div class='line' id='LC50'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">WebView</span> <span class="n">webview</span><span class="o">;</span></div><div class='line' id='LC51'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">EditText</span> <span class="n">edittext</span><span class="o">;</span> </div><div class='line' id='LC52'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">boolean</span> <span class="n">showLocationBar</span> <span class="o">=</span> <span class="kc">true</span><span class="o">;</span></div><div class='line' id='LC53'><br/></div><div class='line' id='LC54'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC55'><span class="cm">     * Executes the request and returns PluginResult.</span></div><div class='line' id='LC56'><span class="cm">     *</span></div><div class='line' id='LC57'><span class="cm">     * @param action        The action to execute.</span></div><div class='line' id='LC58'><span class="cm">     * @param args          JSONArry of arguments for the plugin.</span></div><div class='line' id='LC59'><span class="cm">     * @param callbackId    The callback id used when calling back into JavaScript.</span></div><div class='line' id='LC60'><span class="cm">     * @return              A PluginResult object with a status and message.</span></div><div class='line' id='LC61'><span class="cm">     */</span></div><div class='line' id='LC62'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="n">PluginResult</span> <span class="nf">execute</span><span class="o">(</span><span class="n">String</span> <span class="n">action</span><span class="o">,</span> <span class="n">JSONArray</span> <span class="n">args</span><span class="o">,</span> <span class="n">String</span> <span class="n">callbackId</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC63'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span> <span class="n">status</span> <span class="o">=</span> <span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">OK</span><span class="o">;</span></div><div class='line' id='LC64'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">String</span> <span class="n">result</span> <span class="o">=</span> <span class="s">&quot;&quot;</span><span class="o">;</span></div><div class='line' id='LC65'><br/></div><div class='line' id='LC66'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC67'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">action</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;showWebPage&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC68'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">browserCallbackId</span> <span class="o">=</span> <span class="n">callbackId</span><span class="o">;</span></div><div class='line' id='LC69'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC70'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If the ChildBrowser is already open then throw an error</span></div><div class='line' id='LC71'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">dialog</span> <span class="o">!=</span> <span class="kc">null</span> <span class="o">&amp;&amp;</span> <span class="n">dialog</span><span class="o">.</span><span class="na">isShowing</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC72'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nf">PluginResult</span><span class="o">(</span><span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">ERROR</span><span class="o">,</span> <span class="s">&quot;ChildBrowser is already open&quot;</span><span class="o">);</span></div><div class='line' id='LC73'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC74'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC75'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">result</span> <span class="o">=</span> <span class="k">this</span><span class="o">.</span><span class="na">showWebPage</span><span class="o">(</span><span class="n">args</span><span class="o">.</span><span class="na">getString</span><span class="o">(</span><span class="mi">0</span><span class="o">),</span> <span class="n">args</span><span class="o">.</span><span class="na">optJSONObject</span><span class="o">(</span><span class="mi">1</span><span class="o">));</span></div><div class='line' id='LC76'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC77'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">result</span><span class="o">.</span><span class="na">length</span><span class="o">()</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC78'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">status</span> <span class="o">=</span> <span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">ERROR</span><span class="o">;</span></div><div class='line' id='LC79'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nf">PluginResult</span><span class="o">(</span><span class="n">status</span><span class="o">,</span> <span class="n">result</span><span class="o">);</span></div><div class='line' id='LC80'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC81'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">PluginResult</span> <span class="n">pluginResult</span> <span class="o">=</span> <span class="k">new</span> <span class="n">PluginResult</span><span class="o">(</span><span class="n">status</span><span class="o">,</span> <span class="n">result</span><span class="o">);</span></div><div class='line' id='LC82'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">pluginResult</span><span class="o">.</span><span class="na">setKeepCallback</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC83'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="n">pluginResult</span><span class="o">;</span></div><div class='line' id='LC84'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC85'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC86'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="nf">if</span> <span class="o">(</span><span class="n">action</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;close&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC87'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">closeDialog</span><span class="o">();</span></div><div class='line' id='LC88'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC89'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">JSONObject</span> <span class="n">obj</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JSONObject</span><span class="o">();</span></div><div class='line' id='LC90'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">obj</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="s">&quot;type&quot;</span><span class="o">,</span> <span class="n">CLOSE_EVENT</span><span class="o">);</span></div><div class='line' id='LC91'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC92'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">PluginResult</span> <span class="n">pluginResult</span> <span class="o">=</span> <span class="k">new</span> <span class="n">PluginResult</span><span class="o">(</span><span class="n">status</span><span class="o">,</span> <span class="n">obj</span><span class="o">);</span></div><div class='line' id='LC93'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">pluginResult</span><span class="o">.</span><span class="na">setKeepCallback</span><span class="o">(</span><span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC94'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="n">pluginResult</span><span class="o">;</span></div><div class='line' id='LC95'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC96'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="nf">if</span> <span class="o">(</span><span class="n">action</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;openExternal&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC97'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">result</span> <span class="o">=</span> <span class="k">this</span><span class="o">.</span><span class="na">openExternal</span><span class="o">(</span><span class="n">args</span><span class="o">.</span><span class="na">getString</span><span class="o">(</span><span class="mi">0</span><span class="o">),</span> <span class="n">args</span><span class="o">.</span><span class="na">optBoolean</span><span class="o">(</span><span class="mi">1</span><span class="o">));</span></div><div class='line' id='LC98'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">result</span><span class="o">.</span><span class="na">length</span><span class="o">()</span> <span class="o">&gt;</span> <span class="mi">0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC99'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">status</span> <span class="o">=</span> <span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">ERROR</span><span class="o">;</span></div><div class='line' id='LC100'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC101'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC102'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC103'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">status</span> <span class="o">=</span> <span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">INVALID_ACTION</span><span class="o">;</span></div><div class='line' id='LC104'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC105'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nf">PluginResult</span><span class="o">(</span><span class="n">status</span><span class="o">,</span> <span class="n">result</span><span class="o">);</span></div><div class='line' id='LC106'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">JSONException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC107'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nf">PluginResult</span><span class="o">(</span><span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">JSON_EXCEPTION</span><span class="o">);</span></div><div class='line' id='LC108'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC109'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC110'><br/></div><div class='line' id='LC111'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC112'><span class="cm">     * Display a new browser with the specified URL.</span></div><div class='line' id='LC113'><span class="cm">     *</span></div><div class='line' id='LC114'><span class="cm">     * @param url           The url to load.</span></div><div class='line' id='LC115'><span class="cm">     * @param usePhoneGap   Load url in PhoneGap webview</span></div><div class='line' id='LC116'><span class="cm">     * @return              &quot;&quot; if ok, or error message.</span></div><div class='line' id='LC117'><span class="cm">     */</span></div><div class='line' id='LC118'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="n">String</span> <span class="nf">openExternal</span><span class="o">(</span><span class="n">String</span> <span class="n">url</span><span class="o">,</span> <span class="kt">boolean</span> <span class="n">usePhoneGap</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC119'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC120'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Intent</span> <span class="n">intent</span> <span class="o">=</span> <span class="kc">null</span><span class="o">;</span></div><div class='line' id='LC121'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">usePhoneGap</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC122'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Intent</span><span class="o">().</span><span class="na">setClass</span><span class="o">(</span><span class="k">this</span><span class="o">.</span><span class="na">ctx</span><span class="o">,</span> <span class="n">com</span><span class="o">.</span><span class="na">phonegap</span><span class="o">.</span><span class="na">DroidGap</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></div><div class='line' id='LC123'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span><span class="o">.</span><span class="na">setData</span><span class="o">(</span><span class="n">Uri</span><span class="o">.</span><span class="na">parse</span><span class="o">(</span><span class="n">url</span><span class="o">));</span> <span class="c1">// This line will be removed in future.</span></div><div class='line' id='LC124'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="s">&quot;url&quot;</span><span class="o">,</span> <span class="n">url</span><span class="o">);</span></div><div class='line' id='LC125'><br/></div><div class='line' id='LC126'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Timeout parameter: 60 sec max - May be less if http device timeout is less.</span></div><div class='line' id='LC127'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="s">&quot;loadUrlTimeoutValue&quot;</span><span class="o">,</span> <span class="mi">60000</span><span class="o">);</span></div><div class='line' id='LC128'><br/></div><div class='line' id='LC129'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// These parameters can be configured if you want to show the loading dialog</span></div><div class='line' id='LC130'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="s">&quot;loadingDialog&quot;</span><span class="o">,</span> <span class="s">&quot;Wait,Loading web page...&quot;</span><span class="o">);</span>   <span class="c1">// show loading dialog</span></div><div class='line' id='LC131'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span><span class="o">.</span><span class="na">putExtra</span><span class="o">(</span><span class="s">&quot;hideLoadingDialogOnPageLoad&quot;</span><span class="o">,</span> <span class="kc">true</span><span class="o">);</span>           <span class="c1">// hide it once page has completely loaded</span></div><div class='line' id='LC132'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC133'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC134'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Intent</span><span class="o">(</span><span class="n">Intent</span><span class="o">.</span><span class="na">ACTION_VIEW</span><span class="o">);</span></div><div class='line' id='LC135'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">intent</span><span class="o">.</span><span class="na">setData</span><span class="o">(</span><span class="n">Uri</span><span class="o">.</span><span class="na">parse</span><span class="o">(</span><span class="n">url</span><span class="o">));</span></div><div class='line' id='LC136'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC137'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">ctx</span><span class="o">.</span><span class="na">startActivity</span><span class="o">(</span><span class="n">intent</span><span class="o">);</span></div><div class='line' id='LC138'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="s">&quot;&quot;</span><span class="o">;</span></div><div class='line' id='LC139'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">android</span><span class="o">.</span><span class="na">content</span><span class="o">.</span><span class="na">ActivityNotFoundException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC140'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Log</span><span class="o">.</span><span class="na">d</span><span class="o">(</span><span class="n">LOG_TAG</span><span class="o">,</span> <span class="s">&quot;ChildBrowser: Error loading url &quot;</span><span class="o">+</span><span class="n">url</span><span class="o">+</span><span class="s">&quot;:&quot;</span><span class="o">+</span> <span class="n">e</span><span class="o">.</span><span class="na">toString</span><span class="o">());</span></div><div class='line' id='LC141'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="n">e</span><span class="o">.</span><span class="na">toString</span><span class="o">();</span></div><div class='line' id='LC142'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC143'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC144'><br/></div><div class='line' id='LC145'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC146'><span class="cm">     * Closes the dialog</span></div><div class='line' id='LC147'><span class="cm">     */</span></div><div class='line' id='LC148'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">closeDialog</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC149'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">dialog</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC150'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">stopLoading</span><span class="o">();</span></div><div class='line' id='LC151'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">dismiss</span><span class="o">();</span></div><div class='line' id='LC152'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC153'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC154'><br/></div><div class='line' id='LC155'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC156'><span class="cm">     * Checks to see if it is possible to go back one page in history, then does so.</span></div><div class='line' id='LC157'><span class="cm">     */</span></div><div class='line' id='LC158'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">goBack</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC159'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">canGoBack</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC160'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">goBack</span><span class="o">();</span></div><div class='line' id='LC161'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC162'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC163'><br/></div><div class='line' id='LC164'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC165'><span class="cm">     * Checks to see if it is possible to go forward one page in history, then does so.</span></div><div class='line' id='LC166'><span class="cm">     */</span></div><div class='line' id='LC167'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">goForward</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC168'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">canGoForward</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC169'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">goForward</span><span class="o">();</span></div><div class='line' id='LC170'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC171'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC172'><br/></div><div class='line' id='LC173'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC174'><span class="cm">     * Navigate to the new page</span></div><div class='line' id='LC175'><span class="cm">     * </span></div><div class='line' id='LC176'><span class="cm">     * @param url to load</span></div><div class='line' id='LC177'><span class="cm">     */</span></div><div class='line' id='LC178'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">navigate</span><span class="o">(</span><span class="n">String</span> <span class="n">url</span><span class="o">)</span> <span class="o">{</span>        </div><div class='line' id='LC179'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">InputMethodManager</span> <span class="n">imm</span> <span class="o">=</span> <span class="o">(</span><span class="n">InputMethodManager</span><span class="o">)</span><span class="k">this</span><span class="o">.</span><span class="na">ctx</span><span class="o">.</span><span class="na">getSystemService</span><span class="o">(</span><span class="n">Context</span><span class="o">.</span><span class="na">INPUT_METHOD_SERVICE</span><span class="o">);</span></div><div class='line' id='LC180'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">imm</span><span class="o">.</span><span class="na">hideSoftInputFromWindow</span><span class="o">(</span><span class="n">edittext</span><span class="o">.</span><span class="na">getWindowToken</span><span class="o">(),</span> <span class="mi">0</span><span class="o">);</span></div><div class='line' id='LC181'><br/></div><div class='line' id='LC182'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(!</span><span class="n">url</span><span class="o">.</span><span class="na">startsWith</span><span class="o">(</span><span class="s">&quot;http&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC183'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">loadUrl</span><span class="o">(</span><span class="s">&quot;http://&quot;</span> <span class="o">+</span> <span class="n">url</span><span class="o">);</span>            </div><div class='line' id='LC184'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC185'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">loadUrl</span><span class="o">(</span><span class="n">url</span><span class="o">);</span></div><div class='line' id='LC186'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">webview</span><span class="o">.</span><span class="na">requestFocus</span><span class="o">();</span></div><div class='line' id='LC187'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC188'><br/></div><div class='line' id='LC189'><br/></div><div class='line' id='LC190'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC191'><span class="cm">     * Should we show the location bar?</span></div><div class='line' id='LC192'><span class="cm">     * </span></div><div class='line' id='LC193'><span class="cm">     * @return boolean</span></div><div class='line' id='LC194'><span class="cm">     */</span></div><div class='line' id='LC195'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">boolean</span> <span class="nf">getShowLocationBar</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC196'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="o">.</span><span class="na">showLocationBar</span><span class="o">;</span></div><div class='line' id='LC197'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC198'><br/></div><div class='line' id='LC199'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC200'><span class="cm">     * Display a new browser with the specified URL.</span></div><div class='line' id='LC201'><span class="cm">     *</span></div><div class='line' id='LC202'><span class="cm">     * @param url           The url to load.</span></div><div class='line' id='LC203'><span class="cm">     * @param jsonObject </span></div><div class='line' id='LC204'><span class="cm">     */</span></div><div class='line' id='LC205'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="n">String</span> <span class="nf">showWebPage</span><span class="o">(</span><span class="kd">final</span> <span class="n">String</span> <span class="n">url</span><span class="o">,</span> <span class="n">JSONObject</span> <span class="n">options</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC206'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Determine if we should hide the location bar.</span></div><div class='line' id='LC207'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">options</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC208'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">showLocationBar</span> <span class="o">=</span> <span class="n">options</span><span class="o">.</span><span class="na">optBoolean</span><span class="o">(</span><span class="s">&quot;showLocationBar&quot;</span><span class="o">,</span> <span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC209'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC210'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC211'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Create dialog in new thread </span></div><div class='line' id='LC212'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Runnable</span> <span class="n">runnable</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Runnable</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC213'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">run</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC214'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Dialog</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC215'><br/></div><div class='line' id='LC216'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">requestWindowFeature</span><span class="o">(</span><span class="n">Window</span><span class="o">.</span><span class="na">FEATURE_NO_TITLE</span><span class="o">);</span></div><div class='line' id='LC217'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">setCancelable</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC218'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">setOnDismissListener</span><span class="o">(</span><span class="k">new</span> <span class="n">DialogInterface</span><span class="o">.</span><span class="na">OnDismissListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC219'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDismiss</span><span class="o">(</span><span class="n">DialogInterface</span> <span class="n">dialog</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC220'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC221'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">JSONObject</span> <span class="n">obj</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JSONObject</span><span class="o">();</span></div><div class='line' id='LC222'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">obj</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="s">&quot;type&quot;</span><span class="o">,</span> <span class="n">CLOSE_EVENT</span><span class="o">);</span></div><div class='line' id='LC223'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC224'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">sendUpdate</span><span class="o">(</span><span class="n">obj</span><span class="o">,</span> <span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC225'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">JSONException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC226'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Log</span><span class="o">.</span><span class="na">d</span><span class="o">(</span><span class="n">LOG_TAG</span><span class="o">,</span> <span class="s">&quot;Should never happen&quot;</span><span class="o">);</span></div><div class='line' id='LC227'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC228'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC229'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">});</span></div><div class='line' id='LC230'><br/></div><div class='line' id='LC231'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span> <span class="n">backParams</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">(</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">,</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">);</span></div><div class='line' id='LC232'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span> <span class="n">forwardParams</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">(</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">,</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">);</span></div><div class='line' id='LC233'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span> <span class="n">editParams</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">(</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">,</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">,</span> <span class="mf">1.0f</span><span class="o">);</span></div><div class='line' id='LC234'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span> <span class="n">closeParams</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">(</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">,</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">WRAP_CONTENT</span><span class="o">);</span></div><div class='line' id='LC235'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span> <span class="n">wvParams</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">(</span><span class="n">LayoutParams</span><span class="o">.</span><span class="na">FILL_PARENT</span><span class="o">,</span> <span class="n">LayoutParams</span><span class="o">.</span><span class="na">FILL_PARENT</span><span class="o">);</span></div><div class='line' id='LC236'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC237'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span> <span class="n">main</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC238'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">main</span><span class="o">.</span><span class="na">setOrientation</span><span class="o">(</span><span class="n">LinearLayout</span><span class="o">.</span><span class="na">VERTICAL</span><span class="o">);</span></div><div class='line' id='LC239'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC240'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">LinearLayout</span> <span class="n">toolbar</span> <span class="o">=</span> <span class="k">new</span> <span class="n">LinearLayout</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC241'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">toolbar</span><span class="o">.</span><span class="na">setOrientation</span><span class="o">(</span><span class="n">LinearLayout</span><span class="o">.</span><span class="na">HORIZONTAL</span><span class="o">);</span></div><div class='line' id='LC242'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC243'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">ImageButton</span> <span class="n">back</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ImageButton</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC244'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">back</span><span class="o">.</span><span class="na">setOnClickListener</span><span class="o">(</span><span class="k">new</span> <span class="n">View</span><span class="o">.</span><span class="na">OnClickListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC245'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onClick</span><span class="o">(</span><span class="n">View</span> <span class="n">v</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC246'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">goBack</span><span class="o">();</span></div><div class='line' id='LC247'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC248'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">});</span></div><div class='line' id='LC249'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">back</span><span class="o">.</span><span class="na">setId</span><span class="o">(</span><span class="mi">1</span><span class="o">);</span></div><div class='line' id='LC250'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC251'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">back</span><span class="o">.</span><span class="na">setImageBitmap</span><span class="o">(</span><span class="n">loadDrawable</span><span class="o">(</span><span class="s">&quot;www/childbrowser/icon_arrow_left.png&quot;</span><span class="o">));</span></div><div class='line' id='LC252'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">IOException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC253'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="n">LOG_TAG</span><span class="o">,</span> <span class="n">e</span><span class="o">.</span><span class="na">getMessage</span><span class="o">(),</span> <span class="n">e</span><span class="o">);</span></div><div class='line' id='LC254'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC255'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">back</span><span class="o">.</span><span class="na">setLayoutParams</span><span class="o">(</span><span class="n">backParams</span><span class="o">);</span></div><div class='line' id='LC256'><br/></div><div class='line' id='LC257'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">ImageButton</span> <span class="n">forward</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ImageButton</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC258'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">forward</span><span class="o">.</span><span class="na">setOnClickListener</span><span class="o">(</span><span class="k">new</span> <span class="n">View</span><span class="o">.</span><span class="na">OnClickListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC259'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onClick</span><span class="o">(</span><span class="n">View</span> <span class="n">v</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC260'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">goForward</span><span class="o">();</span></div><div class='line' id='LC261'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC262'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">});</span></div><div class='line' id='LC263'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">forward</span><span class="o">.</span><span class="na">setId</span><span class="o">(</span><span class="mi">2</span><span class="o">);</span></div><div class='line' id='LC264'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC265'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">forward</span><span class="o">.</span><span class="na">setImageBitmap</span><span class="o">(</span><span class="n">loadDrawable</span><span class="o">(</span><span class="s">&quot;www/childbrowser/icon_arrow_right.png&quot;</span><span class="o">));</span></div><div class='line' id='LC266'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">IOException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC267'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="n">LOG_TAG</span><span class="o">,</span> <span class="n">e</span><span class="o">.</span><span class="na">getMessage</span><span class="o">(),</span> <span class="n">e</span><span class="o">);</span></div><div class='line' id='LC268'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span>               </div><div class='line' id='LC269'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">forward</span><span class="o">.</span><span class="na">setLayoutParams</span><span class="o">(</span><span class="n">forwardParams</span><span class="o">);</span></div><div class='line' id='LC270'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC271'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span> <span class="o">=</span> <span class="k">new</span> <span class="n">EditText</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC272'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span><span class="o">.</span><span class="na">setOnKeyListener</span><span class="o">(</span><span class="k">new</span> <span class="n">View</span><span class="o">.</span><span class="na">OnKeyListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC273'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">onKey</span><span class="o">(</span><span class="n">View</span> <span class="n">v</span><span class="o">,</span> <span class="kt">int</span> <span class="n">keyCode</span><span class="o">,</span> <span class="n">KeyEvent</span> <span class="n">event</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC274'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If the event is a key-down event on the &quot;enter&quot; button</span></div><div class='line' id='LC275'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">((</span><span class="n">event</span><span class="o">.</span><span class="na">getAction</span><span class="o">()</span> <span class="o">==</span> <span class="n">KeyEvent</span><span class="o">.</span><span class="na">ACTION_DOWN</span><span class="o">)</span> <span class="o">&amp;&amp;</span> <span class="o">(</span><span class="n">keyCode</span> <span class="o">==</span> <span class="n">KeyEvent</span><span class="o">.</span><span class="na">KEYCODE_ENTER</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC276'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">navigate</span><span class="o">(</span><span class="n">edittext</span><span class="o">.</span><span class="na">getText</span><span class="o">().</span><span class="na">toString</span><span class="o">());</span></div><div class='line' id='LC277'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">true</span><span class="o">;</span></div><div class='line' id='LC278'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC279'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">false</span><span class="o">;</span></div><div class='line' id='LC280'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC281'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">});</span></div><div class='line' id='LC282'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span><span class="o">.</span><span class="na">setId</span><span class="o">(</span><span class="mi">3</span><span class="o">);</span></div><div class='line' id='LC283'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span><span class="o">.</span><span class="na">setSingleLine</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC284'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="n">url</span><span class="o">);</span></div><div class='line' id='LC285'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span><span class="o">.</span><span class="na">setLayoutParams</span><span class="o">(</span><span class="n">editParams</span><span class="o">);</span></div><div class='line' id='LC286'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC287'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">ImageButton</span> <span class="n">close</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ImageButton</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span>                </div><div class='line' id='LC288'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">close</span><span class="o">.</span><span class="na">setOnClickListener</span><span class="o">(</span><span class="k">new</span> <span class="n">View</span><span class="o">.</span><span class="na">OnClickListener</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC289'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onClick</span><span class="o">(</span><span class="n">View</span> <span class="n">v</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC290'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">closeDialog</span><span class="o">();</span></div><div class='line' id='LC291'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC292'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">});</span></div><div class='line' id='LC293'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">close</span><span class="o">.</span><span class="na">setId</span><span class="o">(</span><span class="mi">4</span><span class="o">);</span></div><div class='line' id='LC294'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC295'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">close</span><span class="o">.</span><span class="na">setImageBitmap</span><span class="o">(</span><span class="n">loadDrawable</span><span class="o">(</span><span class="s">&quot;www/childbrowser/icon_close.png&quot;</span><span class="o">));</span></div><div class='line' id='LC296'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">IOException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC297'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Log</span><span class="o">.</span><span class="na">e</span><span class="o">(</span><span class="n">LOG_TAG</span><span class="o">,</span> <span class="n">e</span><span class="o">.</span><span class="na">getMessage</span><span class="o">(),</span> <span class="n">e</span><span class="o">);</span></div><div class='line' id='LC298'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC299'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">close</span><span class="o">.</span><span class="na">setLayoutParams</span><span class="o">(</span><span class="n">closeParams</span><span class="o">);</span></div><div class='line' id='LC300'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC301'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span> <span class="o">=</span> <span class="k">new</span> <span class="n">WebView</span><span class="o">(</span><span class="n">ctx</span><span class="o">);</span></div><div class='line' id='LC302'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">getSettings</span><span class="o">().</span><span class="na">setJavaScriptEnabled</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC303'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">getSettings</span><span class="o">().</span><span class="na">setBuiltInZoomControls</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC304'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">WebViewClient</span> <span class="n">client</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ChildBrowserClient</span><span class="o">(</span><span class="n">ctx</span><span class="o">,</span> <span class="n">edittext</span><span class="o">);</span></div><div class='line' id='LC305'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">setWebViewClient</span><span class="o">(</span><span class="n">client</span><span class="o">);</span>                </div><div class='line' id='LC306'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">loadUrl</span><span class="o">(</span><span class="n">url</span><span class="o">);</span></div><div class='line' id='LC307'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">setId</span><span class="o">(</span><span class="mi">5</span><span class="o">);</span></div><div class='line' id='LC308'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">setInitialScale</span><span class="o">(</span><span class="mi">0</span><span class="o">);</span></div><div class='line' id='LC309'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">setLayoutParams</span><span class="o">(</span><span class="n">wvParams</span><span class="o">);</span></div><div class='line' id='LC310'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">requestFocus</span><span class="o">();</span></div><div class='line' id='LC311'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">webview</span><span class="o">.</span><span class="na">requestFocusFromTouch</span><span class="o">();</span></div><div class='line' id='LC312'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC313'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC314'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">toolbar</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">back</span><span class="o">);</span></div><div class='line' id='LC315'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">toolbar</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">forward</span><span class="o">);</span></div><div class='line' id='LC316'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">toolbar</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">edittext</span><span class="o">);</span></div><div class='line' id='LC317'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">toolbar</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">close</span><span class="o">);</span></div><div class='line' id='LC318'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC319'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">getShowLocationBar</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC320'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">main</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">toolbar</span><span class="o">);</span></div><div class='line' id='LC321'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC322'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">main</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">webview</span><span class="o">);</span></div><div class='line' id='LC323'><br/></div><div class='line' id='LC324'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">WindowManager</span><span class="o">.</span><span class="na">LayoutParams</span> <span class="n">lp</span> <span class="o">=</span> <span class="k">new</span> <span class="n">WindowManager</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">();</span></div><div class='line' id='LC325'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">lp</span><span class="o">.</span><span class="na">copyFrom</span><span class="o">(</span><span class="n">dialog</span><span class="o">.</span><span class="na">getWindow</span><span class="o">().</span><span class="na">getAttributes</span><span class="o">());</span></div><div class='line' id='LC326'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">lp</span><span class="o">.</span><span class="na">width</span> <span class="o">=</span> <span class="n">WindowManager</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">.</span><span class="na">FILL_PARENT</span><span class="o">;</span></div><div class='line' id='LC327'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">lp</span><span class="o">.</span><span class="na">height</span> <span class="o">=</span> <span class="n">WindowManager</span><span class="o">.</span><span class="na">LayoutParams</span><span class="o">.</span><span class="na">FILL_PARENT</span><span class="o">;</span></div><div class='line' id='LC328'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC329'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">setContentView</span><span class="o">(</span><span class="n">main</span><span class="o">);</span></div><div class='line' id='LC330'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">show</span><span class="o">();</span></div><div class='line' id='LC331'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">dialog</span><span class="o">.</span><span class="na">getWindow</span><span class="o">().</span><span class="na">setAttributes</span><span class="o">(</span><span class="n">lp</span><span class="o">);</span></div><div class='line' id='LC332'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC333'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC334'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">Bitmap</span> <span class="nf">loadDrawable</span><span class="o">(</span><span class="n">String</span> <span class="n">filename</span><span class="o">)</span> <span class="kd">throws</span> <span class="n">java</span><span class="o">.</span><span class="na">io</span><span class="o">.</span><span class="na">IOException</span> <span class="o">{</span></div><div class='line' id='LC335'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">InputStream</span> <span class="n">input</span> <span class="o">=</span> <span class="n">ctx</span><span class="o">.</span><span class="na">getAssets</span><span class="o">().</span><span class="na">open</span><span class="o">(</span><span class="n">filename</span><span class="o">);</span>    </div><div class='line' id='LC336'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="n">BitmapFactory</span><span class="o">.</span><span class="na">decodeStream</span><span class="o">(</span><span class="n">input</span><span class="o">);</span></div><div class='line' id='LC337'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC338'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">};</span></div><div class='line' id='LC339'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">ctx</span><span class="o">.</span><span class="na">runOnUiThread</span><span class="o">(</span><span class="n">runnable</span><span class="o">);</span></div><div class='line' id='LC340'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="s">&quot;&quot;</span><span class="o">;</span></div><div class='line' id='LC341'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC342'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC343'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC344'><span class="cm">     * Create a new plugin result and send it back to JavaScript</span></div><div class='line' id='LC345'><span class="cm">     * </span></div><div class='line' id='LC346'><span class="cm">     * @param obj a JSONObject contain event payload information</span></div><div class='line' id='LC347'><span class="cm">     */</span></div><div class='line' id='LC348'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">sendUpdate</span><span class="o">(</span><span class="n">JSONObject</span> <span class="n">obj</span><span class="o">,</span> <span class="kt">boolean</span> <span class="n">keepCallback</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC349'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="k">this</span><span class="o">.</span><span class="na">browserCallbackId</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC350'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">PluginResult</span> <span class="n">result</span> <span class="o">=</span> <span class="k">new</span> <span class="n">PluginResult</span><span class="o">(</span><span class="n">PluginResult</span><span class="o">.</span><span class="na">Status</span><span class="o">.</span><span class="na">OK</span><span class="o">,</span> <span class="n">obj</span><span class="o">);</span></div><div class='line' id='LC351'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">result</span><span class="o">.</span><span class="na">setKeepCallback</span><span class="o">(</span><span class="n">keepCallback</span><span class="o">);</span></div><div class='line' id='LC352'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">success</span><span class="o">(</span><span class="n">result</span><span class="o">,</span> <span class="k">this</span><span class="o">.</span><span class="na">browserCallbackId</span><span class="o">);</span></div><div class='line' id='LC353'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC354'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC355'><br/></div><div class='line' id='LC356'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC357'><span class="cm">     * The webview client receives notifications about appView</span></div><div class='line' id='LC358'><span class="cm">     */</span></div><div class='line' id='LC359'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kd">class</span> <span class="nc">ChildBrowserClient</span> <span class="kd">extends</span> <span class="n">WebViewClient</span> <span class="o">{</span></div><div class='line' id='LC360'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">PhonegapActivity</span> <span class="n">ctx</span><span class="o">;</span></div><div class='line' id='LC361'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">EditText</span> <span class="n">edittext</span><span class="o">;</span></div><div class='line' id='LC362'><br/></div><div class='line' id='LC363'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC364'><span class="cm">         * Constructor.</span></div><div class='line' id='LC365'><span class="cm">         * </span></div><div class='line' id='LC366'><span class="cm">         * @param mContext</span></div><div class='line' id='LC367'><span class="cm">         * @param edittext </span></div><div class='line' id='LC368'><span class="cm">         */</span></div><div class='line' id='LC369'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="nf">ChildBrowserClient</span><span class="o">(</span><span class="n">PhonegapActivity</span> <span class="n">mContext</span><span class="o">,</span> <span class="n">EditText</span> <span class="n">mEditText</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC370'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">ctx</span> <span class="o">=</span> <span class="n">mContext</span><span class="o">;</span></div><div class='line' id='LC371'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">.</span><span class="na">edittext</span> <span class="o">=</span> <span class="n">mEditText</span><span class="o">;</span></div><div class='line' id='LC372'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span>       </div><div class='line' id='LC373'><br/></div><div class='line' id='LC374'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC375'><span class="cm">         * Notify the host application that a page has started loading.</span></div><div class='line' id='LC376'><span class="cm">         * </span></div><div class='line' id='LC377'><span class="cm">         * @param view          The webview initiating the callback.</span></div><div class='line' id='LC378'><span class="cm">         * @param url           The url of the page.</span></div><div class='line' id='LC379'><span class="cm">         */</span></div><div class='line' id='LC380'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC381'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onPageStarted</span><span class="o">(</span><span class="n">WebView</span> <span class="n">view</span><span class="o">,</span> <span class="n">String</span> <span class="n">url</span><span class="o">,</span>  <span class="n">Bitmap</span> <span class="n">favicon</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC382'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">super</span><span class="o">.</span><span class="na">onPageStarted</span><span class="o">(</span><span class="n">view</span><span class="o">,</span> <span class="n">url</span><span class="o">,</span> <span class="n">favicon</span><span class="o">);</span>            </div><div class='line' id='LC383'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">String</span> <span class="n">newloc</span><span class="o">;</span></div><div class='line' id='LC384'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">url</span><span class="o">.</span><span class="na">startsWith</span><span class="o">(</span><span class="s">&quot;http:&quot;</span><span class="o">)</span> <span class="o">||</span> <span class="n">url</span><span class="o">.</span><span class="na">startsWith</span><span class="o">(</span><span class="s">&quot;https:&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC385'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">newloc</span> <span class="o">=</span> <span class="n">url</span><span class="o">;</span></div><div class='line' id='LC386'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC387'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">newloc</span> <span class="o">=</span> <span class="s">&quot;http://&quot;</span> <span class="o">+</span> <span class="n">url</span><span class="o">;</span></div><div class='line' id='LC388'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC389'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC390'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(!</span><span class="n">newloc</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="n">edittext</span><span class="o">.</span><span class="na">getText</span><span class="o">().</span><span class="na">toString</span><span class="o">()))</span> <span class="o">{</span>           </div><div class='line' id='LC391'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">edittext</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="n">newloc</span><span class="o">);</span></div><div class='line' id='LC392'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC393'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC394'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC395'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">JSONObject</span> <span class="n">obj</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JSONObject</span><span class="o">();</span></div><div class='line' id='LC396'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">obj</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="s">&quot;type&quot;</span><span class="o">,</span> <span class="n">LOCATION_CHANGED_EVENT</span><span class="o">);</span></div><div class='line' id='LC397'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">obj</span><span class="o">.</span><span class="na">put</span><span class="o">(</span><span class="s">&quot;location&quot;</span><span class="o">,</span> <span class="n">url</span><span class="o">);</span></div><div class='line' id='LC398'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC399'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">sendUpdate</span><span class="o">(</span><span class="n">obj</span><span class="o">,</span> <span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC400'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">JSONException</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC401'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Log</span><span class="o">.</span><span class="na">d</span><span class="o">(</span><span class="s">&quot;ChildBrowser&quot;</span><span class="o">,</span> <span class="s">&quot;This should never happen&quot;</span><span class="o">);</span></div><div class='line' id='LC402'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC403'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC404'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC405'><span class="o">}</span></div></pre></div>
          </td>
        </tr>
      </table>
  </div>

          </div>
        </div>
      </div>
    </div>

  </div>

<div class="frame frame-loading large-loading-area" style="display:none;" data-tree-list-url="/phonegap/phonegap-plugins/tree-list/2dc6525b2c96f7231d07bb913e6120838bd9caad" data-blob-url-prefix="/phonegap/phonegap-plugins/blob/2dc6525b2c96f7231d07bb913e6120838bd9caad">
  <img src="https://a248.e.akamai.net/assets.github.com/images/spinners/octocat-spinner-64.gif?1329872008" height="64" width="64">
</div>

      </div>
      <div class="context-overlay"></div>
    </div>


      <!-- footer -->
      <div id="footer" >
        
  <div class="upper_footer">
     <div class="container clearfix">

       <!--[if IE]><h4 id="blacktocat_ie">GitHub Links</h4><![endif]-->
       <![if !IE]><h4 id="blacktocat">GitHub Links</h4><![endif]>

       <ul class="footer_nav">
         <h4>GitHub</h4>
         <li><a href="https://github.com/about">About</a></li>
         <li><a href="https://github.com/blog">Blog</a></li>
         <li><a href="https://github.com/features">Features</a></li>
         <li><a href="https://github.com/contact">Contact &amp; Support</a></li>
         <li><a href="https://github.com/training">Training</a></li>
         <li><a href="http://enterprise.github.com/">GitHub Enterprise</a></li>
         <li><a href="http://status.github.com/">Site Status</a></li>
       </ul>

       <ul class="footer_nav">
         <h4>Tools</h4>
         <li><a href="http://get.gaug.es/">Gauges: Analyze web traffic</a></li>
         <li><a href="http://speakerdeck.com">Speaker Deck: Presentations</a></li>
         <li><a href="https://gist.github.com">Gist: Code snippets</a></li>
         <li><a href="http://mac.github.com/">GitHub for Mac</a></li>
         <li><a href="http://mobile.github.com/">Issues for iPhone</a></li>
         <li><a href="http://jobs.github.com/">Job Board</a></li>
       </ul>

       <ul class="footer_nav">
         <h4>Extras</h4>
         <li><a href="http://shop.github.com/">GitHub Shop</a></li>
         <li><a href="http://octodex.github.com/">The Octodex</a></li>
       </ul>

       <ul class="footer_nav">
         <h4>Documentation</h4>
         <li><a href="http://help.github.com/">GitHub Help</a></li>
         <li><a href="http://developer.github.com/">Developer API</a></li>
         <li><a href="http://github.github.com/github-flavored-markdown/">GitHub Flavored Markdown</a></li>
         <li><a href="http://pages.github.com/">GitHub Pages</a></li>
       </ul>

     </div><!-- /.site -->
  </div><!-- /.upper_footer -->

<div class="lower_footer">
  <div class="container clearfix">
    <!--[if IE]><div id="legal_ie"><![endif]-->
    <![if !IE]><div id="legal"><![endif]>
      <ul>
          <li><a href="https://github.com/site/terms">Terms of Service</a></li>
          <li><a href="https://github.com/site/privacy">Privacy</a></li>
          <li><a href="https://github.com/security">Security</a></li>
      </ul>

      <p>&copy; 2012 <span title="0.08216s from fe4.rs.github.com">GitHub</span> Inc. All rights reserved.</p>
    </div><!-- /#legal or /#legal_ie-->

      <div class="sponsor">
        <a href="http://www.rackspace.com" class="logo">
          <img alt="Dedicated Server" height="36" src="https://a248.e.akamai.net/assets.github.com/images/modules/footer/rackspaces_logo.png?1329521040" width="38" />
        </a>
        Powered by the <a href="http://www.rackspace.com ">Dedicated
        Servers</a> and<br/> <a href="http://www.rackspacecloud.com">Cloud
        Computing</a> of Rackspace Hosting<span>&reg;</span>
      </div>
  </div><!-- /.site -->
</div><!-- /.lower_footer -->

      </div><!-- /#footer -->

    

<div id="keyboard_shortcuts_pane" class="instapaper_ignore readability-extra" style="display:none">
  <h2>Keyboard Shortcuts <small><a href="#" class="js-see-all-keyboard-shortcuts">(see all)</a></small></h2>

  <div class="columns threecols">
    <div class="column first">
      <h3>Site wide shortcuts</h3>
      <dl class="keyboard-mappings">
        <dt>s</dt>
        <dd>Focus site search</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>?</dt>
        <dd>Bring up this help dialog</dd>
      </dl>
    </div><!-- /.column.first -->

    <div class="column middle" style='display:none'>
      <h3>Commit list</h3>
      <dl class="keyboard-mappings">
        <dt>j</dt>
        <dd>Move selection down</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>k</dt>
        <dd>Move selection up</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>c <em>or</em> o <em>or</em> enter</dt>
        <dd>Open commit</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>y</dt>
        <dd>Expand URL to its canonical form</dd>
      </dl>
    </div><!-- /.column.first -->

    <div class="column last" style='display:none'>
      <h3>Pull request list</h3>
      <dl class="keyboard-mappings">
        <dt>j</dt>
        <dd>Move selection down</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>k</dt>
        <dd>Move selection up</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>o <em>or</em> enter</dt>
        <dd>Open issue</dd>
      </dl>
    </div><!-- /.columns.last -->

  </div><!-- /.columns.equacols -->

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Issues</h3>

    <div class="columns threecols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt>j</dt>
          <dd>Move selection down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>k</dt>
          <dd>Move selection up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>x</dt>
          <dd>Toggle selection</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>o <em>or</em> enter</dt>
          <dd>Open issue</dd>
        </dl>
      </div><!-- /.column.first -->
      <div class="column middle">
        <dl class="keyboard-mappings">
          <dt>I</dt>
          <dd>Mark selection as read</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>U</dt>
          <dd>Mark selection as unread</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>e</dt>
          <dd>Close selection</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>y</dt>
          <dd>Remove selection from view</dd>
        </dl>
      </div><!-- /.column.middle -->
      <div class="column last">
        <dl class="keyboard-mappings">
          <dt>c</dt>
          <dd>Create issue</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>l</dt>
          <dd>Create label</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>i</dt>
          <dd>Back to inbox</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>u</dt>
          <dd>Back to issues</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>/</dt>
          <dd>Focus issues search</dd>
        </dl>
      </div>
    </div>
  </div>

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Issues Dashboard</h3>

    <div class="columns threecols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt>j</dt>
          <dd>Move selection down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>k</dt>
          <dd>Move selection up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>o <em>or</em> enter</dt>
          <dd>Open issue</dd>
        </dl>
      </div><!-- /.column.first -->
    </div>
  </div>

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Network Graph</h3>
    <div class="columns equacols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt><span class="badmono">←</span> <em>or</em> h</dt>
          <dd>Scroll left</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">→</span> <em>or</em> l</dt>
          <dd>Scroll right</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">↑</span> <em>or</em> k</dt>
          <dd>Scroll up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">↓</span> <em>or</em> j</dt>
          <dd>Scroll down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>t</dt>
          <dd>Toggle visibility of head labels</dd>
        </dl>
      </div><!-- /.column.first -->
      <div class="column last">
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">←</span> <em>or</em> shift h</dt>
          <dd>Scroll all the way left</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">→</span> <em>or</em> shift l</dt>
          <dd>Scroll all the way right</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">↑</span> <em>or</em> shift k</dt>
          <dd>Scroll all the way up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">↓</span> <em>or</em> shift j</dt>
          <dd>Scroll all the way down</dd>
        </dl>
      </div><!-- /.column.last -->
    </div>
  </div>

  <div >
    <div class="rule"></div>
    <div class="columns threecols">
      <div class="column first" >
        <h3>Source Code Browsing</h3>
        <dl class="keyboard-mappings">
          <dt>t</dt>
          <dd>Activates the file finder</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>l</dt>
          <dd>Jump to line</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>w</dt>
          <dd>Switch branch/tag</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>y</dt>
          <dd>Expand URL to its canonical form</dd>
        </dl>
      </div>
    </div>
  </div>
</div>

    <div id="markdown-help" class="instapaper_ignore readability-extra">
  <h2>Markdown Cheat Sheet</h2>

  <div class="cheatsheet-content">

  <div class="mod">
    <div class="col">
      <h3>Format Text</h3>
      <p>Headers</p>
      <pre>
# This is an &lt;h1&gt; tag
## This is an &lt;h2&gt; tag
###### This is an &lt;h6&gt; tag</pre>
     <p>Text styles</p>
     <pre>
*This text will be italic*
_This will also be italic_
**This text will be bold**
__This will also be bold__

*You **can** combine them*
</pre>
    </div>
    <div class="col">
      <h3>Lists</h3>
      <p>Unordered</p>
      <pre>
* Item 1
* Item 2
  * Item 2a
  * Item 2b</pre>
     <p>Ordered</p>
     <pre>
1. Item 1
2. Item 2
3. Item 3
   * Item 3a
   * Item 3b</pre>
    </div>
    <div class="col">
      <h3>Miscellaneous</h3>
      <p>Images</p>
      <pre>
![GitHub Logo](/images/logo.png)
Format: ![Alt Text](url)
</pre>
     <p>Links</p>
     <pre>
http://github.com - automatic!
[GitHub](http://github.com)</pre>
<p>Blockquotes</p>
     <pre>
As Kanye West said:

> We're living the future so
> the present is our past.
</pre>
    </div>
  </div>
  <div class="rule"></div>

  <h3>Code Examples in Markdown</h3>
  <div class="col">
      <p>Syntax highlighting with <a href="http://github.github.com/github-flavored-markdown/" title="GitHub Flavored Markdown" target="_blank">GFM</a></p>
      <pre>
```javascript
function fancyAlert(arg) {
  if(arg) {
    $.facebox({div:'#foo'})
  }
}
```</pre>
    </div>
    <div class="col">
      <p>Or, indent your code 4 spaces</p>
      <pre>
Here is a Python code example
without syntax highlighting:

    def foo:
      if not bar:
        return true</pre>
    </div>
    <div class="col">
      <p>Inline code for comments</p>
      <pre>
I think you should use an
`&lt;addr&gt;` element here instead.</pre>
    </div>
  </div>

  </div>
</div>


    <div class="ajax-error-message">
      <p><span class="icon"></span> Something went wrong with that request. Please try again. <a href="javascript:;" class="ajax-error-dismiss">Dismiss</a></p>
    </div>

    
    
    
    <span id='server_response_time' data-time='0.08334' data-host='fe4'></span>
  </body>
</html>

